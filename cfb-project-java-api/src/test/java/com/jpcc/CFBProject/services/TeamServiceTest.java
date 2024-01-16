package com.jpcc.CFBProject.services;

import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.repository.TeamRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    private Long teamId = 2000L;
    private Team abilene = new Team();

    @BeforeEach
    void setUp() {
        abilene.setId(teamId);
        abilene.setConference("AFC");
        abilene.setDivision("South");
        abilene.setSchool("Abilene Christian");
        teamRepository.save(abilene);
        // Populate the test data using repositories
        // Example: teamRepository.save(new Team(...));
    }

    @Test
    @Sql("/path/to/sql/script.sql") // This is optional and is used if you want to populate data using SQL scripts.
    void findTeamById() throws Exception {
        // Use the service to find the team
        Team team = teamService.findTeamById(teamId);

        // Assertions
        assertNotNull(team, "Team should not be null");
        assertEquals(teamId, team.getId(), "Team ID should match");
        assertEquals(String.class, team.getSchool().getClass(), "Team name should be a String");
        assertEquals("Abilene Christian", team.getSchool(), "Team name should be Abilene Christian");
    }
}
