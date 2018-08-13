package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tournament.service.UserService;
import tournament.treeStructure.TreeStructure;
import tournament.dto.CreateTournamentDto;
import tournament.dto.TournamentDto;
import tournament.model.Tournament;
import tournament.service.TournamentService;

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

    @GetMapping("/getTest")
    public TreeStructure getTest(@RequestParam Long id) {
        Tournament tournament = tournamentService.findOneById(id);
        return new TreeStructure(tournament);
    }

    @PostMapping("/create")
    public String Create(@ModelAttribute CreateTournamentDto dto) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        tournamentService.create(userService.findOneByLogin(name).getId(), dto.getSize(), dto.getName());
        return "create_tournament";
    }
}
