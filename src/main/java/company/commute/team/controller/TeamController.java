package company.commute.team.controller;

import company.commute.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/team")
    public String register(@RequestParam String name) {
        return teamService.register(name);
    }
}