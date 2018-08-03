package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.service.ParticipantService;

@RestController
@RequestMapping("api/participants")
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/join/{tournamentId}/{nick}/{mail}")
    public void Join(@PathVariable Long tournamentId, @PathVariable String nick , @PathVariable String mail) {
        participantService.Join(tournamentId, nick, mail);
    }
}