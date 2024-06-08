package company.commute.employee.repository;

import company.commute.employee.domain.Employee;
import company.commute.employee.domain.EmployeeRole;
import company.commute.team.domain.Team;
import company.commute.team.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Test
    void save() {
        Team teamA = teamRepository.save(
                Team.builder()
                        .name("A")
                        .build()
        );

        Employee employee1 = employeeRepository.save(
                Employee.builder()
                        .team(teamA)
                        .name("김지연")
                        .role(EmployeeRole.MEMBER)
                        .joinDate(LocalDate.parse("2024-06-08"))
                        .birthday(LocalDate.parse("2000-10-16"))
                        .build()
        );

        assertThat(employee1.getTeam().getName()).isEqualTo("A");
    }
}
