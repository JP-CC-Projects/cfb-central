package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    //    Optional<List<Player>> findByTeamAndYear(String schoolName, Integer season); --Add when CFB's API is fixed
    @Query("SELECT p FROM Player p WHERE p.team = :teamName")
    List<Player> findPlayersByTeam(@Param("teamName") String teamName);
    @Transactional
    @Modifying
    @Query("DELETE FROM Player p WHERE p.height IS NULL AND p.position IS NULL")
    void deletePlayersWithNullHeightAndPosition();
    @Query("SELECT p FROM Player p WHERE p.jersey IS NULL")
    List<Player> findPlayersWithNullJersey();
    @Query("SELECT p FROM Player p JOIN p.playerTeamHistories pth WHERE pth.endDate IS NULL")
    List<Player> findAllCurrentPlayers();

}