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
    }

    ;

    @Async
    @Transactional
    public void fetchAndSavePlaysBySeason(Integer year, Integer week, String seasonType) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);
        params.put("week", week);
        params.put("classification", "FBS");
        params.put("seasonType", seasonType);

        int maxRetries = 3;
        int retryCount = 0;
        boolean success = false;

        while (retryCount < maxRetries && !success) {
            try {
                List<Play> savedPlays = fetchSaveAndConvertBatch(
                        cfbApiConfig.getPlaysEndpoint(),
                        params,
                        Play[].class,
                        Function.identity(),
                        this::doesPlayExist,
                        playRepository::saveAll
                );

                // Check if plays are fetched and saved correctly
                if (savedPlays == null || savedPlays.isEmpty()) {
                    throw new RuntimeException("Failed to fetch or save plays for season: " + year +
                            ", week: " + week + ", seasonType: " + seasonType);
                }

                // Print statement after successful batch save operation
                LocalDateTime timestamp = LocalDateTime.now();
                System.out.println("[" + timestamp + "] " +
                        "Batch saved " + savedPlays.size() +
                        " plays for season: " + year + ", week: " + week + ", seasonType: " + seasonType);
                success = true;
            } catch (Exception e) {
                retryCount++;
                System.err.println("Attempt " + retryCount + ": Error during fetching and saving plays: " + e.getMessage());
                if (retryCount >= maxRetries) {
                    throw e; // Rethrow the exception after max retries
                }
            }
        }
    }

    private boolean doesPlayExist(Play play) {
        return playRepository.existsById(play.getId());
    }
}
