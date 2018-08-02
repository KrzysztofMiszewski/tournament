package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;
import tournament.repository.GameRepository;
import tournament.repository.TournamentRepository;
import tournament.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private TournamentRepository tournamentRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, TournamentRepository tournamentRepository) {
        this.gameRepository = gameRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Game showCurrentGame(int round, int gameNumber) {
        return gameRepository.findOneByRoundAndGameNumber(round, gameNumber);
    }

    @Override
    public void selectWinner(Game game, Participant winner) {
        if (isFinal(game)) {
            Tournament tournament = game.getTournament();
            tournament.setWinner(winner.getNick());
            tournamentRepository.save(tournament);
        } else {
            game.setWinner(winner.getNick());
            gameRepository.save(game);
        }
    }

    @Override
    public void create(Tournament tournament, int round, int gameNumber) {
        Game game = new Game();
        game.setTournament(tournament);
        game.setGameNumber(gameNumber);
        game.setRound(round);
        gameRepository.save(game);
    }

    public boolean isFinal(Game game) {
        if (game.getRound() == 0) {
            return true;
        } else
            return false;
    }

}
