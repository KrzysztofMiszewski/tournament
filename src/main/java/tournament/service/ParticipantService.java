package tournament.service;

import tournament.model.Participant;
import tournament.model.Tournament;

public interface ParticipantService {
 void Join(Tournament tournament, String nick, String mail);
  Participant participant = new Participant();

}
