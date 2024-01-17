package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.boxscore.BoxScore;
import com.jpcc.CFBProject.repository.BoxScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class BoxScoreService extends BaseService {
    private BoxScoreRepository boxScoreRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public BoxScoreService(BoxScoreRepository boxScoreRepository,
                           RestTemplate restTemplate,
                           CFBApiConfig cfbApiConfig,
                           @Qualifier("objectMapper") ObjectMapper objectMapper,
                           WebClient webClient) {
        super(webClient, objectMapper, cfbApiConfig);
        this.boxScoreRepository = boxScoreRepository;
        this.restTemplate = restTemplate;
    }

    public BoxScore fetechSaveAndReturnBoxScore(Long gameId) throws Exception {
        String boxScoreJsonString = fetchJsonFromApi(
                cfbApiConfig.getBoxScoreEndpoint(),
                Map.of("gameId", gameId)
        );
        BoxScore newBoxScore = objectMapper.readValue(boxScoreJsonString, BoxScore.class);
        boxScoreRepository.save(newBoxScore);
        return newBoxScore;
    }
}
