package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.SeasonWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeekRepository extends JpaRepository<SeasonWeek, Long> {
    SeasonWeek save(SeasonWeek seasonWeek);
    Optional<SeasonWeek> findBySeasonAndWeekNumber(Integer season, Integer weekNumber);
}
