package tournament.service;

import org.springframework.stereotype.Service;
import tournament.model.Game;
import tournament.model.Participant;

@Service
public interface GameService {

    Game showCurrentGame(Game game);
    void selectWinner(Game game, Participant white, Participant black);
    }
