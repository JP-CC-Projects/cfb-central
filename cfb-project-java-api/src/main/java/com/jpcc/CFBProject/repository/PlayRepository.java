package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.Play;
import com.jpcc.CFBProject.dto.CalculateQuarterScoresDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayRepository extends JpaRepository<Play, Long> {

    boolean existsById(Long id);
    @Query("SELECT new com.jpcc.CFBProject.dto.CalculateQuarterScoresDTO(p.away, p.home, p.offense, p.offenseScore, p.defense, p.defenseScore, p.period, p.playType) " +
            "FROM Play p WHERE p.gameId = :gameId AND p.playType LIKE 'END%'")
    List<CalculateQuarterScoresDTO> findPlaysByGameId(@Param("gameId") Long gameId);
}
