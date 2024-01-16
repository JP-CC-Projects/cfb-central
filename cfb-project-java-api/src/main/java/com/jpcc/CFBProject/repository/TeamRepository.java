package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.dto.TeamListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team save(Team team);
    Optional<Team> findTeamById(Long teamId);
    Optional<Team> findBySchool(String name);
    @Query("SELECT new com.jpcc.CFBProject.dto.TeamListDTO(t.id, t.school, t.mascot) FROM Team t")
    List<TeamListDTO> findAllTeamsMinimal();
    long count();
}
