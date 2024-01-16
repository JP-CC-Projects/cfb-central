package com.jpcc.CFBProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.domain.TeamRecord;
import com.jpcc.CFBProject.dto.TeamOverviewDTO;
import com.jpcc.CFBProject.dto.TeamListDTO;
import com.jpcc.CFBProject.dto.TimeLineSeasonGamesDTO;
import com.jpcc.CFBProject.repository.GameRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import com.jpcc.CFBProject.services.GameService;
import com.jpcc.CFBProject.services.PlayerService;
import com.jpcc.CFBProject.services.TeamRecordService;
import com.jpcc.CFBProject.services.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ComponentScan
@RestController
public class TeamController {
    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    private final TeamService teamService;
    private TeamRepository teamRepository;
    private final ObjectMapper objectMapper;
    private final GameRepository gameRepository;
    private final GameService gameService;
    private final TeamRecordService teamRecordService;
    private final PlayerService playerService;

    @Autowired
    public TeamController(TeamService teamService,
                          TeamRepository teamRepository,
                          ObjectMapper objectMapper,
                          GameRepository gameRepository, GameService gameService, TeamRecordService teamRecordService, PlayerService playerService) {
        this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.objectMapper = objectMapper;
        this.gameRepository = gameRepository;
        this.gameService = gameService;
        this.teamRecordService = teamRecordService;
        this.playerService = playerService;
    }

    @GetMapping("/api/teamlist-min")
    public ResponseEntity<List<TeamListDTO>> getTeamsMinimal() {
        List<TeamListDTO> teams = teamRepository.findAllTeamsMinimal();
        logger.info("Returning minimal team list with size: {}", teams.size());
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/api/team-default")
    public ResponseEntity<Team> getTeamById(
            @RequestParam(required = true) Long teamId) throws Exception {
        Team team = teamService.findTeamById(teamId);
        // Convert the Team object to JSON and log it
        String teamJson = objectMapper.writeValueAsString(team);
        logger.info("Team Default JSON: {}", teamJson);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/api/team-overview")
    public ResponseEntity<TeamOverviewDTO> getTeamOverview(
            @RequestParam(required = true) Long teamId) throws Exception {
        TeamOverviewDTO teamOverviewDto = null; //Add call to Dto service later
        // Convert the Team object to JSON and log it
        String teamJson = objectMapper.writeValueAsString(teamOverviewDto);
        logger.info("Team Overview DTO JSON: {}", teamJson);
        return ResponseEntity.ok(teamOverviewDto);
    }

    @GetMapping("/api/team-timeline")
    public ResponseEntity<List<TimeLineSeasonGamesDTO>> getTeamTimeline(
            @RequestParam(required = true) Long teamId,
            @RequestParam(required = true) Integer season) throws Exception {
        List<TimeLineSeasonGamesDTO> timelineGames = gameService.getGamesAndConvertToDTO(teamId, season);
        return ResponseEntity.ok(timelineGames);
    }

    @GetMapping("/api/team-record")
    public ResponseEntity<TeamRecord> getRecord(
            @RequestParam(required = true) Long teamId,
            @RequestParam(required = true) Integer season) throws Exception {
        TeamRecord teamRecord = teamRecordService.getTeamRecordByTeamIdAndYear(teamId, season);
        String teamJson = objectMapper.writeValueAsString(teamRecord);
        logger.info("Team Record: {}", teamJson);
        return ResponseEntity.ok(teamRecord);
    }

    @GetMapping("/api/team-roster")
    public ResponseEntity<List<Player>> getRoster(
            @RequestParam(required = true) Long teamId,
            @RequestParam(required = true) Integer season) throws Exception {
        List<Player> teamRoster = playerService.getPlayerListByTeam(teamId);
        String teamJson = objectMapper.writeValueAsString(teamRoster);
        return ResponseEntity.ok(teamRoster);
    }
    @GetMapping("/api/team-charts")
    public ResponseEntity<List<Player>> getChart(
            @RequestParam(required = true) Long teamId,
            @RequestParam(required = false) Integer season) throws Exception {
        List<Player> teamRoster = playerService.getPlayerListByTeam(teamId);
        String teamJson = objectMapper.writeValueAsString(teamRoster);
        return ResponseEntity.ok(teamRoster);
    }
}
