package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game save(Game team);
    Optional<Game> findGameById(Long gameId);
    @Query("SELECT g FROM Game g WHERE (g.awayId = :teamId OR g.homeId = :teamId) AND g.season = :season")
    List<Game> findGamesByTeamAndYear(@Param("teamId") Long teamId, @Param("season") Integer season);
    @Query("SELECT g.id FROM Game g")
    List<Long> findAllGameIds();

    boolean existsById(Long id);
    long count();
}
