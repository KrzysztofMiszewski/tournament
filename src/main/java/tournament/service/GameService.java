package tournament.service;

import org.springframework.stereotype.Service;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;

@Service
public interface GameService {

    Game showCurrentGame(Game game);
    void selectWinner(Game game, Participant winner);
    void create(Tournament tournament, int round, int gameNumber);
    }
