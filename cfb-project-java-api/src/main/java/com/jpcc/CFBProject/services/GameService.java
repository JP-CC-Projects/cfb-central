package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.Game;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.domain.relationship.QuarterScores;
import com.jpcc.CFBProject.dto.CalculateQuarterScoresDTO;
import com.jpcc.CFBProject.dto.TimeLineSeasonGamesDTO;
import com.jpcc.CFBProject.repository.GameRepository;
import com.jpcc.CFBProject.repository.PlayRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

//    0. find games by team and year from game repo
//    1. create base google API
//        base: https://customsearch.googleapis.com/customsearch/v1?
//        search engine: &cx=c7dbc6ee92da44cdb
//        key: &key=AIzaSyAN4N1_mhGGrYS3PGf2wn3guVhXCIqGZXo
//        params: num=3&searchType=image
//        query: &q="cool image of " + venue + "football" + year
//    2. Extract thumbnail URL and source name for each URL
//    3. Put in DTO
//

@Service
public class GameService extends BaseService {

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private final PlayRepository playRepository;

    @Autowired
    public GameService(GameRepository gameRepository,
                       TeamRepository teamRepository,
                       @Qualifier("objectMapper") ObjectMapper objectMapper,
                       CFBApiConfig cfbApiConfig,
                       WebClient webClient, PlayRepository playRepository) {
        super(webClient, objectMapper, cfbApiConfig);
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
        this.playRepository = playRepository;
    }

    public void fetchAndSaveGames(Integer year, String seasonType) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("division", "fbs");
        params.put("seasonType", seasonType); // Add seasonType parameter
        fetchSaveAndConvert(
                cfbApiConfig.getGamesEndpoint(),
                params,
                Game[].class,
                Function.identity(),
                this::doesGameExist,
                gameRepository::save
        );
        System.out.println(seasonType + " games for " + year + "saved to database");
    }

    private boolean doesGameExist(Game game) {
        return gameRepository.existsById(game.getId());
    }

    public List<TimeLineSeasonGamesDTO> getGamesAndConvertToDTO(Long teamId, Integer year) {
        List<Game> games = gameRepository.findGamesByTeamAndYear(teamId, year);
        return convertGamesToDTOs(games);
    }

    private List<TimeLineSeasonGamesDTO> convertGamesToDTOs(List<Game> games) {
        List<TimeLineSeasonGamesDTO> dtoList = new ArrayList<>();
        for (Game game : games) {
            String venueImageUrl = getVenueImageUrlForTeam(game.getHomeId());
            TimeLineSeasonGamesDTO dto = createDTOFromGame(game, venueImageUrl);
            dtoList.add(dto);
        }
        dtoList.sort(Comparator.comparing(TimeLineSeasonGamesDTO::getDate).reversed());
        return dtoList;
    }

    private String getVenueImageUrlForTeam(Long teamId) {
        Optional<Team> homeTeam = teamRepository.findById(teamId);
        if (homeTeam.isPresent()) {
            String venueImageUrl = homeTeam.get().getLocation().getVenueImageUrl();
            if (venueImageUrl == null) {
                venueImageUrl = handleMissingVenueImageUrl(
                        homeTeam.get().getSchool(),
                        homeTeam.get().getLocation().getName());
                homeTeam.get().getLocation().setVenueImageUrl(venueImageUrl);
                teamRepository.save(homeTeam.get());
            }
            System.out.println("Venue Image URL = " + venueImageUrl);
            return venueImageUrl;
        }
        return null;
    }

    @Transactional
    public String handleMissingVenueImageUrl(String teamName, String venueName) {

        String searchQuery = "cool image of " + teamName + " " + venueName + " football";
        Mono<String> fetchedVenueUrlMono = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/customsearch/v1")
                        .queryParam("key", googleApiKey)
                        .queryParam("cx", googleSearchCx)
                        .queryParam("searchType", "image")
                        .queryParam("num", "3")
                        .queryParam("q", searchQuery)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> {
                    try {
                        JsonNode root = objectMapper.readTree(response);
                        JsonNode itemsNode = root.path("items");
                        if (!itemsNode.isMissingNode() && itemsNode.isArray() && itemsNode.size() > 0) {
                            for(int i = 0; i < itemsNode.size(); i++){
                                if(itemsNode.get(i).path("link").asText().length() < 799){
                                    return itemsNode.get(i).path("link").asText();
                                }
                                else{
                                    return "";
                                }
                            }
                        }
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                });
        return fetchedVenueUrlMono.block(); // This blocks until the mono is fulfilled. Use with caution.
    }

    private TimeLineSeasonGamesDTO createDTOFromGame(Game game, String venueImageUrl) {
        return new TimeLineSeasonGamesDTO(
                game.getId(),
                game.getStartDate(),
                game.getAwayTeam() + " @ " + game.getHomeTeam(),
                "Card Subtitle", // Replace with actual subtitle if available
                "Card Detailed Text", // Replace with actual detailed text if available
                "https://www.example.com", // LINK TO GAME DETAILS PAGE
                "IMAGE", // Replace with actual media type if available
                venueImageUrl, // Replace with actual media URL if available
                "Game Highlights", // Replace with actual media name if available
                game.getQuarterScores()
        );
    }

    public void calculateAllQuarterScores(){
        List<Long> gameIdsList = gameRepository.findAllGameIds();
        for (Long gameId : gameIdsList) {
            calculateQuarterScores(gameId);
        }
    }
    @Async
    @Transactional
    public void calculateQuarterScores(Long gameId) {
        List<CalculateQuarterScoresDTO> plays = playRepository.findPlaysByGameId(gameId);
        Game game = gameRepository.findGameById(gameId).orElse(null);
        if (game != null && game.getQuarterScores().getQ1AwayTeamScore() != null) {
            System.out.println("Quarter scores for Game with ID " + gameId + " already exist.");
            return;
        }
        QuarterScores quarterScores = new QuarterScores();
        List<CalculateQuarterScoresDTO> sortedPlays = plays.stream()
                .filter(play -> play.getPeriod() != null)
                .sorted(Comparator.comparingInt(CalculateQuarterScoresDTO::getPeriod))
                .toList();
        Integer previousHomeScore = 0;
        Integer previousAwayScore = 0;

        for (CalculateQuarterScoresDTO play : sortedPlays) {
            // Determine home or away for each quarter:
            Integer homeScore = play.getHomeTeam().equals(play.getOffenseTeam()) ? play.getOffenseScore() : play.getDefenseScore();
            Integer awayScore = play.getAwayTeam().equals(play.getOffenseTeam()) ? play.getOffenseScore() : play.getDefenseScore();

            // Determine the quarter and set the scores
            switch (play.getPeriod()) {
                case 1 -> {
                    quarterScores.setQ1HomeTeamScore(homeScore);
                    quarterScores.setQ1AwayTeamScore(awayScore);
                    quarterScores.setQ1HomeTeamPointsScored(homeScore);
                    quarterScores.setQ1AwayTeamPointsScored(awayScore);
                }
                case 2 -> {
                    quarterScores.setQ2HomeTeamScore(homeScore);
                    quarterScores.setQ2AwayTeamScore(awayScore);
                    quarterScores.setQ2HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setQ2AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 3 -> {
                    quarterScores.setQ3HomeTeamScore(homeScore);
                    quarterScores.setQ3AwayTeamScore(awayScore);
                    quarterScores.setQ3HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setQ3AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 4 -> {
                    quarterScores.setQ4HomeTeamScore(homeScore);
                    quarterScores.setQ4AwayTeamScore(awayScore);
                    quarterScores.setQ4HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setQ4AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 5 -> {
                    quarterScores.setOt1HomeTeamScore(homeScore);
                    quarterScores.setOt1AwayTeamScore(awayScore);
                    quarterScores.setOt1HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt1AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 6 -> {
                    quarterScores.setOt2HomeTeamScore(homeScore);
                    quarterScores.setOt2AwayTeamScore(awayScore);
                    quarterScores.setOt2HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt2AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 7 -> {
                    quarterScores.setOt3HomeTeamScore(homeScore);
                    quarterScores.setOt3AwayTeamScore(awayScore);
                    quarterScores.setOt3HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt3AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 8 -> {
                    quarterScores.setOt4HomeTeamScore(homeScore);
                    quarterScores.setOt4AwayTeamScore(awayScore);
                    quarterScores.setOt4HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt4AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 9 -> {
                    quarterScores.setOt5HomeTeamScore(homeScore);
                    quarterScores.setOt5AwayTeamScore(awayScore);
                    quarterScores.setOt5HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt5AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 10 -> {
                    quarterScores.setOt6HomeTeamScore(homeScore);
                    quarterScores.setOt6AwayTeamScore(awayScore);
                    quarterScores.setOt6HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt6AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 11 -> {
                    quarterScores.setOt7HomeTeamScore(homeScore);
                    quarterScores.setOt7AwayTeamScore(awayScore);
                    quarterScores.setOt7HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt7AwayTeamPointsScored(awayScore - previousAwayScore);
                }
                case 12 -> {
                    quarterScores.setOt8HomeTeamScore(homeScore);
                    quarterScores.setOt8AwayTeamScore(awayScore);
                    quarterScores.setOt8HomeTeamPointsScored(homeScore - previousHomeScore);
                    quarterScores.setOt8AwayTeamPointsScored(awayScore - previousAwayScore);
                }
            }
            previousHomeScore = homeScore;
            previousAwayScore = awayScore;
        }
        game.setQuarterScores(quarterScores);
        gameRepository.save(game);
        System.out.println("Quarter Scores for Game with ID " + gameId + " calculated and saved successfully.");
    }
}
