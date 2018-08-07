package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.aaa.TreeStructure;
import tournament.dto.TournamentDto;
import tournament.model.Tournament;
import tournament.service.TournamentService;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
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

    @GetMapping("/getTest")
    public TreeStructure getTest(@RequestParam Long id) {
        Tournament tournament = tournamentService.findOneById(id);
        return new TreeStructure(tournament);
    }
}
