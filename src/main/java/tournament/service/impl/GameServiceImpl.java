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
    public Game showCurrentGame(Game game) {
        game.getGameNumber();
        game.getRound();
        gameRepository.save(game);
        return game;
    }

    @Override
    public void selectWinner(Game game, Participant winner) {
        if (isFinal(game) == true) {
            Tournament tournament = game.getTournament();
            tournament.setWinner(winner.getNick());
            tournamentRepository.save(tournament);
        } else {
            game.setWinner(winner);
            gameRepository.save(game);
        }
    }

    @Override
    public void create(Tournament tournament, int round, int gameNumber) {
        Game game = new Game();
        game.setTournament(tournament);
        game.getGameNumber();
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
