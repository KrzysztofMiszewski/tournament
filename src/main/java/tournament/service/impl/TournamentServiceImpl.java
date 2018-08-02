package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;
import tournament.model.User;
import tournament.repository.GameRepository;
import tournament.repository.TournamentRepository;
import tournament.service.GameService;
import tournament.service.TournamentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TournamentServiceImpl implements TournamentService {

    private TournamentRepository tournamentRepository;
    private GameRepository gameRepository;
    private GameService gameService;

    @Autowired
    public TournamentServiceImpl(TournamentRepository tournamentRepository, GameRepository gameRepository, GameService gameService) {
        this.tournamentRepository = tournamentRepository;
        this.gameRepository = gameRepository;
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
    public Tournament findOneById(Long id) {
        return tournamentRepository.findOneById(id);
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
        int rounds = createGames(tournament);
        randomiseParticipants(tournament, rounds);
        autoResolveWildcards(tournament, rounds);
    }

    private void autoResolveWildcards(Tournament tournament, int rounds) {
        Set<Game> games = gameService.findOneByRoundAndTournament_IdAndBlackIsNull(rounds - 1, tournament.getId());
        for (Game game : games) {
            gameService.selectWinner(game, game.getWhite());
        }
    }

    private void randomiseParticipants(Tournament tournament, int rounds) {
        List<Participant> participants = new ArrayList<>(tournament.getParticipants());
        int games = (int) Math.pow(2, rounds);
        Game game;
        for (int i = 0; i < games; i += 2) {
            int index = (int) (Math.random() * participants.size());
            game = gameService.findOneByRoundAndGameNumberAndTournament_Id(rounds - 1, i, tournament.getId());
            game.setWhite(participants.remove(index));
            gameRepository.save(game);
        }
        for (int i = 1; i < games && !participants.isEmpty(); i += 2) {
            int index = (int) (Math.random() * participants.size());
            game = gameRepository.findOneByRoundAndGameNumberAndTournament_Id(rounds - 1, i, tournament.getId());
            game.setBlack(participants.remove(index));
            gameRepository.save(game);
        }
    }

    private int createGames(Tournament tournament) {
        int participants = tournament.getParticipants().size();
        int rounds = 1;
        int games = 1;
        while (participants > games * 2) {
            games *= 2;
            rounds++;
        }
        for (int row = 0; row < rounds; row++) {
            for (int game = 0; game < (row+1)*2; game++) {
                gameService.create(tournament, row, game);
            }
        }
        tournamentRepository.save(tournament);
        return rounds;
    }
}
