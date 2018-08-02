package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tournament.model.Tournament;
import tournament.model.User;
import tournament.repository.TournamentRepository;
import tournament.service.GameService;
import tournament.service.TournamentService;

import java.util.Set;

public class TournamentServiceImpl implements TournamentService {

    private TournamentRepository tournamentRepository;
    private GameService gameService;

    @Autowired
    public TournamentServiceImpl(TournamentRepository tournamentRepository, GameService gameService) {
        this.tournamentRepository = tournamentRepository;
        this.gameService = gameService;
    }

    @Override
    public Set<Tournament> findAllBy() {
        return tournamentRepository.findAllBy();
    }

    @Override
    public Set<Tournament> findAllByIsStartedIsFalse() {
        return tournamentRepository.findAllByIsStartedIsFalse();
    }

    @Override
    public Boolean isStarted(Tournament tournament) {
        return tournament.getStarted();
    }

    @Override
    public Tournament create(User user, Integer maxPop, String name) {
        Tournament tournament = new Tournament();
        tournament.setMaxPop(maxPop);
        tournament.setName(name);
        tournament.setOwner(user);
        tournamentRepository.save(tournament);
        return tournament;
    }

    @Override
    @Transactional
    public void start(Tournament tournament) {

    }

    private void createGames(Tournament tournament) {
        int participants = tournament.getParticipants().size();
        int rounds = 0;
        int games = 1;
        while (participants > games * 2) {
            games *= 2;
            rounds++;
        }

    }
}
