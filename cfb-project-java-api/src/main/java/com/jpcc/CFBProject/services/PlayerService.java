package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.domain.relationship.PlayerTeamHistory;
import com.jpcc.CFBProject.repository.PlayerRepository;
import com.jpcc.CFBProject.repository.PlayerTeamHistoryRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.*;

@Service
public class PlayerService extends BaseService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerTeamHistoryRepository playerTeamHistoryRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository,
                         ObjectMapper objectMapper,
                         CFBApiConfig cfbApiConfig,
                         WebClient webClient,
                         TeamRepository teamRepository,
                         PlayerTeamHistoryRepository playerTeamHistoryRepository) {
        super(webClient, objectMapper, cfbApiConfig);
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.playerTeamHistoryRepository = playerTeamHistoryRepository;
    }

    @Transactional
    public List<Player> fetchAndSavePlayers(String teamName, Integer year) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("team", teamName);
        String json = fetchJsonFromApi(cfbApiConfig.getRosterEndpoint(), params);
        Player[] allFetchedPlayers = objectMapper.readValue(json, Player[].class);
        // Process each player and save if not exists
        Instant now = Instant.now();
        for (Player player : allFetchedPlayers) {
            Team team = teamRepository.findBySchool(player.getTeam()).orElse(null);
            Optional<Player> existingPlayer = playerRepository.findById(player.getId());
            if (existingPlayer.isPresent()) {
                PlayerTeamHistory currentHistory = playerTeamHistoryRepository
                        .findCurrentByPlayerId(player.getId()).orElse(null);
                if (currentHistory != null && !currentHistory.getTeam().equals(team)) {
                    currentHistory.setEndDate(now);
                    playerTeamHistoryRepository.save(currentHistory);
                }
            } else {
                playerRepository.save(player); // Save new player
            }
            // Save new history record
            playerTeamHistoryRepository.save(new PlayerTeamHistory(player, team, now));
        }
        return Arrays.asList(allFetchedPlayers);
    }

    public Boolean doesPlayerExist(Player player) {
        return playerRepository.existsById(player.getId());
    }

    public List<Player> getPlayerListByTeamIdAndYear(Long teamId, Integer season) throws Exception {
        String schoolName = teamRepository.findTeamById(teamId).get().getSchool();
        //          Add player history when CFB's API gets fixed //
        //        List<Player> = playerRepository.findByTeamAndYear(schoolName, season);
        System.out.println("School name via getPlayerListByTeamIdAndYear = " + schoolName);
        List<Player> fetchedPlayers = fetchAndSavePlayers(schoolName, season);
        for (Player player : fetchedPlayers) {
        }
        return fetchedPlayers;
    }

    public List<Player> getPlayerListByTeam(Long teamId) {
        String schoolName = teamRepository.findTeamById(teamId).get().getSchool();
        List<Player> playerList = playerRepository.findPlayersByTeam(schoolName);
        return playerList;
    }

    public void calculateAndSetPlayerHometownDistanceToSchool(Long playerId) {
        Player player = playerRepository.findById(playerId).orElse(null);
        if (player == null) {
            // Optionally log that the player was not found
            return;
        }

        Team team = teamRepository.findBySchool(player.getTeam()).orElse(null);
        if (team == null || team.getLocation() == null) {
            // Optionally log that the team or location was not found
            return;
        }

        Double playerLatitude = player.getHomeLatitude();
        Double playerLongitude = player.getHomeLongitude();
        Double teamLatitude = team.getLocation().getLatitude();
        Double teamLongitude = team.getLocation().getLongitude();

        // Check if any latitude or longitude is null
        if (playerLatitude == null || playerLongitude == null || teamLatitude == null || teamLongitude == null) {
            System.out.println("Coordinates not found for player" + player.getFirstName() + " " + player.getLastName());
            return; // Do nothing if any coordinate is null
        }

        Double distance = haversineCalculation(playerLatitude, playerLongitude, teamLatitude, teamLongitude);
        player.setDistanceToSchool(distance);
        System.out.println(player.getFirstName() + " " + player.getLastName() +
                " is " + distance + " miles from " + team.getSchool());
        playerRepository.save(player);
    }

    public Double haversineCalculation(double schoolLat, double schoolLon,
                                       double playerLat, double playerLon) {
        double distanceToSchool;
        double dLat = Math.toRadians(playerLat - schoolLat);
        double dLon = Math.toRadians(playerLon - schoolLon);
        schoolLat = Math.toRadians(schoolLat);
        playerLat = Math.toRadians(playerLat);
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(schoolLat) *
                        Math.cos(playerLat);
        double rad = 3959D;
        double c = 2 * Math.asin(Math.sqrt(a));
        distanceToSchool = rad * c;
        return distanceToSchool;
    }
}
