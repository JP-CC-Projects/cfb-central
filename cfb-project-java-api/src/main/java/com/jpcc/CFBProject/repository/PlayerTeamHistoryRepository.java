package com.jpcc.CFBProject.repository;


import com.jpcc.CFBProject.domain.Player;
import com.jpcc.CFBProject.domain.relationship.PlayerTeamHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerTeamHistoryRepository extends JpaRepository<PlayerTeamHistory, Long> {
    @Query("SELECT pth FROM PlayerTeamHistory pth WHERE pth.player.id = :playerId AND pth.endDate IS NULL")
    Optional<PlayerTeamHistory> findCurrentByPlayerId(Long playerId);
    @Query("SELECT pl FROM PlayerTeamHistory pl WHERE pl.team.id = :teamId AND pl.endDate IS NULL")
    List<Player> findCurrentRosterByTeamId(@Param("teamId") Long teamId);
}
