package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tournament.dto.CreateTournamentDto;
import tournament.dto.JoinTournamentDto;
import tournament.service.ParticipantService;
import tournament.service.TournamentService;

@Controller
@RequestMapping("api/participants")
public class ParticipantController {

    private ParticipantService participantService;
    private TournamentService tournamentService;

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
    public String Join(@ModelAttribute JoinTournamentDto dto) {
        participantService.Join(dto.getTournamentId(), dto.getNickname(), dto.getEmail());
        return "join";
    }


}