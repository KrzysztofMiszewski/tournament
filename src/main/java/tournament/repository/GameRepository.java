package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Game;
import tournament.model.Participant;

@Repository
public interface GameRepository extends CrudRepository <Game, Long> {

    Game showCurrentGame(Game game);
    void selectWinner(Game game, Participant white, Participant black);

}
