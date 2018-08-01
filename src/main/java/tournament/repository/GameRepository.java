package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;

@Repository
public interface GameRepository extends CrudRepository <Game, Long> {

    Game showCurrentGame(Game game);
    void selectWinner(Game game, Participant winner);
    void create(Tournament tournament, int round, int gameNumber);
    Game findOneByRoundAndGameNumber(int round, int gameNumber);
    }
