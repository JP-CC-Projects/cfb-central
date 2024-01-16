package com.jpcc.CFBProject.services;

import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.dto.NationChartDataDTO;
import com.jpcc.CFBProject.dto.PlayerChartDataDTO;
import com.jpcc.CFBProject.dto.TeamChartDataDTO;
import com.jpcc.CFBProject.repository.PlayerRepository;
import com.jpcc.CFBProject.repository.PlayerTeamHistoryRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

@Service
public class ChartDataService {
    private TeamService teamService;
    private PlayerService playerService;
    private PlayerTeamHistoryRepository playerTeamHistoryRepository;
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public ChartDataService(TeamService teamService, PlayerTeamHistoryRepository playerTeamHistoryRepository,
                            PlayerRepository playerRepository,
                            TeamRepository teamRepository) {
        this.teamService = teamService;
        this.playerTeamHistoryRepository = playerTeamHistoryRepository;
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }
    public List<PlayerChartDataDTO> getPlayerChartData(Long teamId){
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) {
            // Handle the case where the team is not found, possibly throw an exception or return an empty list
            return Collections.emptyList();
        }
        String teamName = team.getSchool();
        return playerRepository.findPlayersByTeam(teamName).stream()
                .map(player -> new PlayerChartDataDTO(
                        player.getId(),
                        player.getFirstName(),
                        player.getLastName(),
                        player.getWeight(),
                        player.getHeight(),
                        player.getDistanceToSchool(),
                        player.getYear(),
                        player.getPosition()))
                .collect(Collectors.toList());
    }
    public NationChartDataDTO getNationAvgChartData() {
        List<Player> allPlayers = playerRepository.findAllCurrentPlayers();

        Double natAvgWeight = calculateAverage(allPlayers, Player::getWeight);
        Double natAvgHeight = calculateAverage(allPlayers, Player::getHeight);
        Double natAvgDistance = calculateAverage(allPlayers, Player::getDistanceToSchool);
        Double natAvgYear = calculateAverage(allPlayers, Player::getYear);

        NationChartDataDTO nationChartDataDTO = new NationChartDataDTO();
        nationChartDataDTO.setNatAvgWeight(natAvgWeight);
        nationChartDataDTO.setNatAvgHeight(natAvgHeight);
        nationChartDataDTO.setNatAvgDistance(natAvgDistance);
        nationChartDataDTO.setNatAvgYear(natAvgYear);

        return nationChartDataDTO;
    }
    public List<TeamChartDataDTO> getAllTeamsChartData() {
        List<Team> teams = teamRepository.findAll();
        List<TeamChartDataDTO> chartData = new ArrayList<>();

        for (Team team : teams) {
            List<Player> players = team.getPlayerTeamHistories().stream()
                    .map(playerTeamHistory -> playerTeamHistory.getPlayer())
                    .collect(Collectors.toList());

            double avgWeight = calculateAverage(players, Player::getWeight);
            double avgHeight = calculateAverage(players, Player::getHeight);
            double avgDistance = calculateAverage(players, Player::getDistanceToSchool);
            double avgYear = calculateAverage(players, Player::getYear);

            TeamChartDataDTO dto = new TeamChartDataDTO();
            dto.setTeamId(team.getId());
            dto.setTeamName(team.getSchool());
            dto.setTeamAvgWeight(avgWeight);
            dto.setTeamAvgHeight(avgHeight);
            dto.setTeamAvgDistance(avgDistance);
            dto.setTeamAvgYear(avgYear);
            chartData.add(dto);
        }
        return chartData;
    }
    private double calculateAverage(List<Player> players, ToDoubleFunction<Player> mapper) {
        return players.stream()
                .mapToDouble(mapper)
                .average()
                .orElse(0.0);
    }
}

