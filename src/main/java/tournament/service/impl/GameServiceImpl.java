package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;
import tournament.repository.GameRepository;
import tournament.service.GameService;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game showCurrentGame(Game game) {
        return null;
    }

    @Override
    public void selectWinner(Game game, Participant winner) {
        if (isFinal(game) == true ) {
           Tournament tournament = game.getTournament();

        }

        gameRepository.save();
    }

    public boolean isFinal (Game game){
        if (game.getRound() == 0){
            return true;
        }
        else
            return false;
    }

}
