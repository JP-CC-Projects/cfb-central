package com.jpcc.CFBProject.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpcc.CFBProject.config.CFBApiConfig;
import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.repository.PlayerTeamHistoryRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import com.jpcc.CFBProject.util.HttpUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamService {
    private static final Logger logger = LoggerFactory.getLogger(TeamService.class);

    @Value("${cfbApiKey}")
    private String cfbApiKey;
    private final TeamRepository teamRepository;
    private final CFBApiConfig cfbApiConfig;
    private final ObjectMapper objectMapper;
    private final PlayerTeamHistoryRepository playerTeamHistoryRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository,
                       CFBApiConfig cfbApiConfig,
                       @Qualifier("objectMapper") ObjectMapper objectMapper, // specify the bean here
                       PlayerTeamHistoryRepository playerTeamHistoryRepository) {
        this.teamRepository = teamRepository;
        this.cfbApiConfig = cfbApiConfig;
        this.objectMapper = objectMapper;
        this.playerTeamHistoryRepository = playerTeamHistoryRepository;
    }

    @Transactional
    public void fetchAndSaveTeams() throws Exception {
        Map<String, Object> queryParams = new HashMap<>();
        String teamsJsonString = HttpUtil.makeApiCall(cfbApiConfig.getBase(),
                cfbApiConfig.getFbsTeamsEndpoint(),
                cfbApiKey, queryParams
        );

        System.out.println("Teams JSON = " + teamsJsonString);
        List<Team> teams = convertJsonStringToTeamObjects(teamsJsonString);
        for(Team team : teams){
            if (teamRepository.findTeamById(team.getId()).isPresent()){
                return;
            }
            else{
                teamRepository.save(team);
            }
        }
    }

    public List<Team> convertJsonStringToTeamObjects(String jsonString) throws Exception {
        return objectMapper.readValue(jsonString, new TypeReference<List<Team>>() {
        });
    }

    public Team findTeamById(Long teamId) throws Exception {
        logger.info("Fetching team with ID: {}", teamId);
        Optional<Team> team = teamRepository.findTeamById(teamId);
        if (team.isPresent()) {
            logger.info("Team found: {}", team.get());
            return team.get();
        } else {
            logger.warn("No team found with ID: {}", teamId);
            return null;
        }
    }

    public List<Player> currentRosterByTeamId(Long teamId) {
        List<Player> currentRoster = playerTeamHistoryRepository.findCurrentRosterByTeamId(teamId);
        return currentRoster;
    }
}
