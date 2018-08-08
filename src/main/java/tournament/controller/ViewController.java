package tournament.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tournament.model.Tournament;
import tournament.repository.TournamentRepository;
import tournament.repository.UserRepository;

import java.util.Set;

@Controller
public class ViewController {

    private TournamentRepository tournamentRepository;
    private UserRepository userRepository;

    public ViewController(TournamentRepository tournamentRepository, UserRepository userRepository) {
        this.tournamentRepository = tournamentRepository;
        this.userRepository = userRepository;
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

}
