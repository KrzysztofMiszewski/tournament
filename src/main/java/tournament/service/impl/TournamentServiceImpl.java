package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;
import tournament.repository.GameRepository;
import tournament.repository.ParticipantRepository;
import tournament.repository.TournamentRepository;
import tournament.repository.UserRepository;
import tournament.service.GameService;
import tournament.service.TournamentService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class TournamentServiceImpl implements TournamentService {

    private TournamentRepository tournamentRepository;
    private UserRepository userRepository;
    private GameRepository gameRepository;
    private GameService gameService;
    private ParticipantRepository participantRepository;

    @Autowired
    public TournamentServiceImpl(TournamentRepository tournamentRepository, UserRepository userRepository, GameRepository gameRepository, GameService gameService, ParticipantRepository participantRepository) {
        this.tournamentRepository = tournamentRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.gameService = gameService;
        this.participantRepository = participantRepository;
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
    public Tournament create(Long userId, Integer maxPop, String name) {
        Tournament tournament = new Tournament();
        tournament.setMaxPop(maxPop);
        tournament.setName(name);
        tournament.setOwner(userRepository.findOne(userId));
        tournamentRepository.save(tournament);
        return tournament;
    }

    @Override
    @Transactional
    public void start(Long id) {
        Tournament tournament = tournamentRepository.findOneById(id);
        int rounds = createGames(tournament);
        randomiseParticipants(tournament, rounds);
        autoResolveWildcards(tournament, rounds);
    }

    private void autoResolveWildcards(Tournament tournament, int rounds) {
        Set<Game> games = gameService.findOneByRoundAndTournament_IdAndBlackIsNull(rounds, tournament.getId());
        for (Game game : games) {
            gameService.selectWinner(game, game.getWhite());
        }
    }

    private void randomiseParticipants(Tournament tournament, int rounds) {
        List<Participant> participants = new ArrayList<>(tournament.getParticipants());
        int games = (int) Math.pow(2, rounds);
        Game game;
        for (int i = 0; i < games; i++) {
            int index = (int) (Math.random() * participants.size());
            game = gameService.findOneByRoundAndGameNumberAndTournament_Id(rounds, i, tournament.getId());
            game.setWhite(participants.remove(index));
            gameRepository.save(game);
        }
        int j = games / 2;
        for (int i = 0; i < games && !participants.isEmpty(); i++) {
            int index = (int) (Math.random() * participants.size());
            if (i % 2 == 0)
                game = gameRepository.findOneByRoundAndGameNumberAndTournament_Id(rounds, (j + i), tournament.getId());
            else game = gameRepository.findOneByRoundAndGameNumberAndTournament_Id(rounds, (j - i), tournament.getId());
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
            for (int game = 0; game < (int) Math.pow(2, row); game++) {
                gameService.create(tournament.getId(), row, game);
            }
        }
        tournamentRepository.save(tournament);
        return rounds - 1;
    }
}
