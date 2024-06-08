package company.commute.team.repository;

import company.commute.team.domain.Team;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void save() {
        Team team1 = teamRepository.save(
                Team.builder()
                        .name("test1")
                        .build()
        );

        Team findTeam = teamRepository.findByName("test1");
        log.info("===========================");
        log.info("Id={}", findTeam.getId());
        log.info("name={}", findTeam.getName());
        log.info("employee={}", findTeam.getEmployees());
        assertThat(team1.getId()).isEqualTo(findTeam.getId());
    }
}