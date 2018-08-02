package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.model.Tournament;
import tournament.service.ParticipantService;

@RestController
@RequestMapping("api/participants")
public class ParticipantController {

    private ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }
      //@GetMapping
   // public void Join(){return participantService.Join();}
}