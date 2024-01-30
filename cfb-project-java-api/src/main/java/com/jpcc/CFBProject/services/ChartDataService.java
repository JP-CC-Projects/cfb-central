package com.jpcc.CFBProject.services;

import com.jpcc.CFBProject.domain.NationChartData;
import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.dto.NationChartDataDTO;
import com.jpcc.CFBProject.dto.PlayerChartDataDTO;
import com.jpcc.CFBProject.dto.TeamChartDataDTO;
import com.jpcc.CFBProject.repository.NationChartDataRepository;
import com.jpcc.CFBProject.repository.PlayerRepository;
import com.jpcc.CFBProject.repository.PlayerTeamHistoryRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ChartDataService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final NationChartDataRepository nationChartDataRepository;

    public ChartDataService(PlayerRepository playerRepository,
                            TeamRepository teamRepository,
                            NationChartDataRepository nationChartDataRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.nationChartDataRepository = nationChartDataRepository;
    }
    public List<PlayerChartDataDTO> getPlayerChartData(Long teamId){
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) {
            throw new IllegalArgumentException("Team is null.");
        }
        String teamName = team.getSchool();
        return playerRepository.findPlayersByTeam(teamName).stream()
                .filter(Objects::nonNull)
                .map(player -> new PlayerChartDataDTO(
                        player.getId(),
                        player.getFirstName(),
                        player.getLastName(),
                        player.getWeight(),
                        player.getHeight(),
                        player.getDistanceToSchool(),
                        player.getYear(),
                        player.getPosition(),
                        player.getJersey()))
                .collect(Collectors.toList());
    }
    public NationChartDataDTO getNationAvgChartData() {
        // Check if the data already exists in the database
        Optional<NationChartData> existingData = nationChartDataRepository.findLatestEntry();

        if (existingData.isPresent()) {
            // Convert existing entity to DTO and return it
            return convertToDTO(existingData.get());
        } else {
            // Calculate the averages
            List<Player> allPlayers = playerRepository.findAllCurrentPlayers();
            Double natAvgWeight = calculateAverage(allPlayers, Player::getWeight);
            Double natAvgHeight = calculateAverage(allPlayers, Player::getHeight);
            Double natAvgDistance = calculateAverage(allPlayers, Player::getDistanceToSchool);
            Double natAvgYear = calculateAverage(allPlayers, Player::getYear);

            // Save the new averages to the database
            NationChartData newNationChartAvgs = new NationChartData();
            newNationChartAvgs.setNatAvgWeight(natAvgWeight);
            newNationChartAvgs.setNatAvgHeight(natAvgHeight);
            newNationChartAvgs.setNatAvgDistance(natAvgDistance);
            newNationChartAvgs.setNatAvgYear(natAvgYear);
            nationChartDataRepository.save(newNationChartAvgs);

            // Convert and return the new DTO
            return convertToDTO(newNationChartAvgs);
        }
    }
    private NationChartDataDTO convertToDTO(NationChartData data) {
        NationChartDataDTO dto = new NationChartDataDTO();
        dto.setNatAvgWeight(data.getNatAvgWeight());
        dto.setNatAvgHeight(data.getNatAvgHeight());
        dto.setNatAvgDistance(data.getNatAvgDistance());
        dto.setNatAvgYear(data.getNatAvgYear());
        return dto;
    }

    public List<TeamChartDataDTO> getAllTeamsChartData() {
        List<Team> teams = teamRepository.findAll();
        List<TeamChartDataDTO> chartData = new ArrayList<>();

        for (Team team : teams) {
            List<Player> players = team.getPlayerTeamHistories().stream()
                    .map(playerTeamHistory -> playerTeamHistory.getPlayer())
                    .collect(Collectors.toList());

            Double avgWeight = calculateAverage(players, Player::getWeight);
            Double avgHeight = calculateAverage(players, Player::getHeight);
            Double avgDistance = calculateAverage(players, Player::getDistanceToSchool);
            Double avgYear = calculateAverage(players, Player::getYear);

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
    private double calculateAverage(List<Player> players, Function<Player, Number> mapper) {
        return players.stream()
                .map(mapper)
                .filter(Objects::nonNull)
                .mapToDouble(Number::doubleValue)
                .average()
                .orElse(0.0);
    }
}

