package tournament.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tournament.dto.JoinTournamentDto;
import tournament.dto.CreateTournamentDto;
import tournament.model.Tournament;
import tournament.repository.TournamentRepository;
import tournament.repository.UserRepository;
import tournament.service.TournamentService;
import java.util.Set;

@Controller
public class ViewController {

    private TournamentRepository tournamentRepository;
    private UserRepository userRepository;
    private TournamentService tournamentService;

    public ViewController(TournamentRepository tournamentRepository, UserRepository userRepository, TournamentService tournamentService) {
        this.tournamentRepository = tournamentRepository;
        this.userRepository = userRepository;
        this.tournamentService = tournamentService;
    }

    @GetMapping(value = {"", "/", "index.html"})
    public String home() {
        return "index";
    }

    @GetMapping("logging_success_page")
    public String loggingSuccess(Model model) {
        model.addAttribute("login", SecurityContextHolder.getContext().getAuthentication().getName());
        return "logging_success_page";
    }

    @GetMapping("/user_panel")
    public String tournamentsList(Model model) {
        Set<Tournament> allByOwnerId = tournamentRepository.findAllByOwnerId(userRepository.findOneByLogin(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
        model.addAttribute("tournaments", allByOwnerId);
        return "user_panel";
    }

    @PostMapping("/user_panel/start/{tournamentId}")
    public RedirectView tournamentStart(@PathVariable Long tournamentId, RedirectAttributes attributes) {
        tournamentService.start(tournamentId);
        return new RedirectView("/user_panel");
    }

    @GetMapping("/view/show-tournament/{tournamentId}")
    public RedirectView tournamentShow(@PathVariable("tournamentId") String tournamentId, RedirectAttributes attributes) {
        attributes.addAttribute("tournamentId", tournamentId);
        return new RedirectView("/show-tournament");
    }

    @GetMapping("show-tournament")
    public String showTournament(Model model, @ModelAttribute("tournamentId") Long tournamentId) {
        model.addAttribute("tournamentId", tournamentId);
        return "tournamentChart";
    }

    @GetMapping("create_tournament")
    public String createTournament(Model model) {
        model.addAttribute("dto", new CreateTournamentDto());
        return "/create_tournament";
    }

    @GetMapping("join")
    public String tournamentsOpenList(Model model) {
        Set<Tournament> allByOwnerId = tournamentRepository.findAllByStartedIsFalse();
        model.addAttribute("tournaments", allByOwnerId);
        return "join";
    }

    @GetMapping("joinRegister/{tournamentId}")
    public String joinRegister(@PathVariable Long tournamentId, Model model) {
        model.addAttribute("tournamentId", tournamentId);
        Tournament tournament = tournamentRepository.findOneById(tournamentId);
        model.addAttribute("tournamentName", tournament.getName());
        model.addAttribute("dto", new JoinTournamentDto());
        return "joinRegister";
    }
}

