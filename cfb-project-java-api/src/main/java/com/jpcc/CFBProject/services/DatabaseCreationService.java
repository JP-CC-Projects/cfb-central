package com.jpcc.CFBProject.services;

import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.repository.PlayerRepository;
import com.jpcc.CFBProject.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DatabaseCreationService {

    private PlayerService playerService;
    private TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public DatabaseCreationService(PlayerService playerService, TeamRepository teamRepository,
                                   PlayerRepository playerRepository) {
        this.playerService = playerService;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }
    //Get all players for all teams:
    @Transactional
    public void fetchAndSaveAllPlayers(){
        for(Team team : teamRepository.findAll()){
            List<Player> playerList = null;
            try {
                playerList = playerService.getPlayerListByTeamIdAndYear(team.getId(), 2023);
                Thread.sleep(3000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (Player player : playerList){
                playerService.calculateAndSetPlayerHometownDistanceToSchool(player.getId());
            }
        };
    };

    //Fix database:
    //Removes duplicate players who are entered with null fields:
    public void removeNullPlayers(){
        playerRepository.deletePlayersWithNullHeightAndPosition();
    }
    //After duplicate players have been removed, remaining players have Jersey #0:
    public void correctNullJerseys(){
        List<Player> nullJerseyPlayer = playerRepository.findPlayersWithNullJersey();
        for (Player player : nullJerseyPlayer){
            player.setJersey(0);
            playerRepository.save(player);
        }
    }
}
