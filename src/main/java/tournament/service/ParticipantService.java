package tournament.service;

import org.springframework.stereotype.Service;
import tournament.model.Participant;
import tournament.model.Tournament;

@Service
public interface ParticipantService {
 void Join(Tournament tournament, String nick, String mail);
  Participant participant = new Participant();

}
