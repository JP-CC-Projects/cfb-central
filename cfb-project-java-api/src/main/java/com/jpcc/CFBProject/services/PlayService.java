package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.Play;
import com.jpcc.CFBProject.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service

public class PlayService extends BaseService {
    private final PlayRepository playRepository;
    private final GameService gameService;

    @Autowired
    public PlayService(PlayRepository playRepository,
                       @Qualifier("objectMapper") ObjectMapper objectMapper,
                       CFBApiConfig cfbApiConfig,
                       WebClient webClient, GameService gameService) {
        super(webClient, objectMapper, cfbApiConfig);
        this.playRepository = playRepository;
        this.gameService = gameService;
    };

    @Async
    @Transactional
    public List<Play> fetchAndSavePlaysBySeason(Integer year, Integer week, String seasonType) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("week", week);
        params.put("seasonType", seasonType);

        List<Play> savedPlays = fetchSaveAndConvertBatch(
                cfbApiConfig.getPlaysEndpoint(),
                params,
                Play[].class,
                Function.identity(),
                this::doesPlayExist,
                playRepository::saveAll
        );
        // Print statement after batch save operation
        LocalDateTime timestamp = LocalDateTime.now();
        System.out.println("[" + timestamp + "] " +
                "Batch saved " + savedPlays.size() +
                " plays for season: " + year + ", week: " + week + ", seasonType: " + seasonType);
        return savedPlays;
    }


    @Transactional
    public List<Play> fetchAndSavePlaysBySeasonAndWeek(Integer year, Integer week, String seasonType) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("week", week);
        params.put("classification", "FBS");
        params.put("seasonType", seasonType);

        List<Play> savedPlays = fetchSaveAndConvert(
                cfbApiConfig.getPlaysEndpoint(),
                params,
                Play[].class,
                Function.identity(),
                this::doesPlayExist,
                playRepository::save
        );
        // Print statement after save operation
        System.out.println("Saved " + savedPlays.size() + " plays for season " + year + ", week " + week + ", season type " + seasonType);
        return savedPlays;
    }

    private boolean doesPlayExist(Play play) {
        return playRepository.existsById(play.getId());
    }
}
