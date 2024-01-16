package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.boxscore.BoxScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BoxScoreRepository extends JpaRepository<BoxScore, Long> {
    BoxScore save(BoxScore boxScore);
    Optional<BoxScore> findBoxScoreByGameId(Long gameId);
}
