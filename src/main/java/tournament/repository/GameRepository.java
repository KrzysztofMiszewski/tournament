package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;

@Repository
public interface GameRepository extends CrudRepository <Game, Long> {

    //Game showCurrentGame(Game game); wywołuje błąd
   // void selectWinner(Game game, Participant winner); wywołuje błąd
   // void create(Tournament tournament, int round, int gameNumber); wywołuje błąd
    Game findOneByRoundAndGameNumber(int round, int gameNumber);
    }
