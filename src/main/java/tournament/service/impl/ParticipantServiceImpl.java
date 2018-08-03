package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tournament.model.Participant;
import tournament.model.Tournament;
import tournament.repository.ParticipantRepository;
import tournament.repository.TournamentRepository;
import tournament.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private TournamentRepository tournamentRepository;
    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantServiceImpl(TournamentRepository tournamentRepository, ParticipantRepository participantRepository) {
        this.tournamentRepository = tournamentRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public void Join(Long tournamentId, String nick, String mail) {
        Participant participant = new Participant();
        Tournament tournament = tournamentRepository.findOne(tournamentId);
        participant.setNick(nick);
        participant.setMail(mail);
        participant.getTournaments().add(tournament);
        tournament.getParticipants().add(participant);
        participantRepository.save(participant);
    }
}
