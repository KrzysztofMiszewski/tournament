package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tournament.dto.TournamentDto;
import tournament.model.Tournament;
import tournament.service.TournamentService;
import tournament.service.UserService;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private TournamentService tournamentService;
    private UserService userService;

    @Autowired
    public TournamentController(TournamentService tournamentService, UserService userService) {
        this.tournamentService = tournamentService;
        this.userService = userService;
    }

    @PostMapping("/new/{userId}/{maxPop}/{name}")
    public TournamentDto newTournament(@PathVariable Long userId, @PathVariable int maxPop, @PathVariable String name) {
        return new TournamentDto(tournamentService.create(userId, maxPop, name));
    }
}
