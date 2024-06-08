package company.commute.employee.domain;

import company.commute.team.domain.Team;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

@Getter @NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "name"})})
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Comment("직원 이름")
    @Column(nullable = false, length = 20)
    private String name;

    @Comment("팀 매니저 여부")
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @Comment("입사 날짜")
    private LocalDate joinDate;

    @Comment("생일")
    private LocalDate birthday;

    @Builder
    public Employee(Team team, String name, EmployeeRole role, LocalDate joinDate, LocalDate birthday) {
        this.team = team;
        this.name = name;
        this.role = role;
        this.joinDate = joinDate;
        this.birthday = birthday;
    }
}
