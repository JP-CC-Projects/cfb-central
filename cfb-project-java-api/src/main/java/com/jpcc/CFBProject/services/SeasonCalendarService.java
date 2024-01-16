package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.SeasonWeek;
import com.jpcc.CFBProject.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class SeasonCalendarService extends BaseService {
    private final WeekRepository weekRepository;

    @Autowired
    public SeasonCalendarService(WeekRepository weekRepository,
                                 @Qualifier("noSnakeObjectMapper") ObjectMapper objectMapper,
                                 CFBApiConfig cfbApiConfig,
                                 WebClient webClient) {
        super(webClient, objectMapper, cfbApiConfig);
        this.weekRepository = weekRepository;
    }


    public void fetchAndSaveWeeks(Integer seasonYear) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("year", seasonYear);
        fetchSaveAndConvert(
                cfbApiConfig.getCalendarEndpoint(),
                params,
                SeasonWeek[].class,
                Function.identity(), // If no transformation is required
                this::doesWeekExist,
                weekRepository::save
        );
    }

    private boolean doesWeekExist(SeasonWeek seasonWeek) {
        return weekRepository.findBySeasonAndWeekNumber(seasonWeek.getSeason(), seasonWeek.getWeekNumber()).isPresent();
    }
}
