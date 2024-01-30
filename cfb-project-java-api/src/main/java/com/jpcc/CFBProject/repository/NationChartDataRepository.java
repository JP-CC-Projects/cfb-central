package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.NationChartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NationChartDataRepository extends JpaRepository<NationChartData, Long> {
    @Query("SELECT n FROM NationChartData n ORDER BY n.updatedAt DESC")
    Optional<NationChartData> findLatestEntry();
}