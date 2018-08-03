package tournament.service;

import tournament.model.Tournament;

public interface ParticipantService {

    void Join(Long tournamentId, String nick, String mail);

}
