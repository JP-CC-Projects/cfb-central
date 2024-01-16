package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.TeamRecord;
import com.jpcc.CFBProject.repository.TeamRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class TeamRecordService extends BaseService {

    private final TeamRecordRepository teamRecordRepository;

    @Autowired
    public TeamRecordService(TeamRecordRepository teamRecordRepository,
                             @Qualifier("noSnakeObjectMapper") ObjectMapper objectMapper,
                             CFBApiConfig cfbApiConfig,
                             WebClient webClient) {
        super(webClient, objectMapper, cfbApiConfig);
        this.teamRecordRepository = teamRecordRepository;
    }


    //    Admin Method:
    public List<TeamRecord> fetchAndSaveTeamRecords(Integer year) throws Exception {
        return fetchSaveAndConvert(
                cfbApiConfig.getRecordsEndpoint(),
                Map.of("year", year),
                TeamRecord[].class,
                Function.identity(), // Assuming the JSON directly maps to TeamRecord
                this::doesTeamRecordExist, // Method to check if record exists
                teamRecordRepository::save // Method to save a single record
        );
    }

    private boolean doesTeamRecordExist(TeamRecord record) {
        return teamRecordRepository.existsByTeamIdAndYear(record.getTeamId(), record.getYear());
    }
    public TeamRecord getTeamRecordByTeamIdAndYear(Long teamId, Integer year) {
        return teamRecordRepository.findTeamRecordByIdAndYear(teamId, year);
    }
}
