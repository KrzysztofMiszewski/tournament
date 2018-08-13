package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import tournament.dto.JoinTournamentDto;
import tournament.service.ParticipantService;

@Controller
@RequestMapping("api/participants")
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @ResponseBody
    @PostMapping("/join/{tournamentId}/{nick}/{mail}")
    public void Join(@PathVariable Long tournamentId, @PathVariable String nick , @PathVariable String mail) {
        participantService.Join(tournamentId, nick, mail);
    }

    @PostMapping("/join")
    public RedirectView Join(@ModelAttribute JoinTournamentDto dto) {
        participantService.Join(dto.getTournamentId(), dto.getNickname(), dto.getEmail());
        return new RedirectView("/join");
    }
}