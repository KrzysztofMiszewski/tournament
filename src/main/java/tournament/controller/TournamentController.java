package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/start/{tournamentId}")
    public void startTournament(@PathVariable Long tournamentId) {
        tournamentService.start(tournamentId);
    }

    @GetMapping("/get/{tournamentId}")
    public TournamentDto getTournament(@PathVariable Long tournamentId) {
        return new TournamentDto(tournamentService.findOneById(tournamentId));
    }
}
