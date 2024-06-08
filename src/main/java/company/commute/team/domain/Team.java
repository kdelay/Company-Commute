package company.commute.team.domain;

import company.commute.employee.domain.Employee;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter @NoArgsConstructor
@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "team")
    List<Employee> employees = new ArrayList<>();

    @Comment("팀명")
    @Column(nullable = false, unique = true, length = 20)
    private String name;

    @Builder
    public Team(String name) {
        this.name = name;
    }
}