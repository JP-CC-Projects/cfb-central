package com.jpcc.CFBProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.dto.NationChartDataDTO;
import com.jpcc.CFBProject.dto.PlayerChartDataDTO;
import com.jpcc.CFBProject.dto.TeamChartDataDTO;
import com.jpcc.CFBProject.services.ChartDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartController {
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(ChartController.class);

    private ChartDataService chartDataService;

    public ChartController(ObjectMapper objectMapper, ChartDataService chartDataService) {
        this.objectMapper = objectMapper;
        this.chartDataService = chartDataService;
    }

    @GetMapping("/api/chart/players")
    public ResponseEntity<List<PlayerChartDataDTO>> getSelectedTeamChartData(
            @RequestParam(required = true) Long teamId) throws JsonProcessingException {
        List<PlayerChartDataDTO> playerChartData = chartDataService.getPlayerChartData(teamId);
        String playerChartJSON = objectMapper.writeValueAsString(playerChartData);
        logger.info("Player Chart DTO JSON: {}", playerChartJSON);
        return ResponseEntity.ok(playerChartData);
    }

    @Cacheable(value = "allTeamsChartData")
    @GetMapping("/api/chart/all-teams-avgs")
    public ResponseEntity<List<TeamChartDataDTO>> getAllTeamsChartData() {
        try {
            List<TeamChartDataDTO> teamChartDataDTO = chartDataService.getAllTeamsChartData();
            return ResponseEntity.ok(teamChartDataDTO);
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Cacheable(value = "nationalAvgChartData")
    @GetMapping("/api/chart/nat-avg")
    public ResponseEntity<NationChartDataDTO> getNationAvgChartData() {
        try {
            NationChartDataDTO nationChartData = chartDataService.getNationAvgChartData();
            return ResponseEntity.ok(nationChartData);
        } catch (Exception e) {
            // Handle exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
