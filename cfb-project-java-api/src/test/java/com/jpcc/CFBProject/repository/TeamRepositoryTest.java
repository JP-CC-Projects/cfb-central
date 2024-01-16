package com.jpcc.CFBProject.repository;

import com.jpcc.CFBProject.domain.Team;
import com.jpcc.CFBProject.dto.TeamListDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TeamRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void testFindAllTeamsMinimal() {
        // Arrange - Add some test data
        Team team = new Team();
        team.setId(1L);
        team.setSchool("Test School");
        team.setMascot("Test Mascot");
        entityManager.persist(team);
        entityManager.flush();

        // Act - Call your method
        List<TeamListDTO> result = teamRepository.findAllTeamsMinimal();

        // Assert - Check the results
        assertFalse(result.isEmpty());
        assertEquals("Test School", result.get(0).getSchool());
        assertEquals("Test Mascot", result.get(0).getMascot());
    }
}
