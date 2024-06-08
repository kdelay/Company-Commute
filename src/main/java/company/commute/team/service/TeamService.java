package company.commute.team.service;

import company.commute.team.domain.Team;
import company.commute.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public String register(String name) {
        teamRepository.save(Team.builder()
                            .name(name)
                            .build());
        return "success";
    }
}
