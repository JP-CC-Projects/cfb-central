package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.TeamRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRecordRepository extends JpaRepository<TeamRecord, Long> {
    TeamRecord save(TeamRecord teamRecord);
    Optional<TeamRecord> findTeamRecordById(Long teamId);
    @Query("SELECT t FROM TeamRecord t WHERE (t.teamId = :teamId) AND t.year = :year")
    TeamRecord findTeamRecordByIdAndYear(Long teamId, Integer year);

    boolean existsByTeamIdAndYear(Long teamId, Integer year);
}