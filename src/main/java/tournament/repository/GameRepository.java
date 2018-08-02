package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Game;
import java.util.Set;

@Repository
public interface GameRepository extends CrudRepository <Game, Long> {
      Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id);
      Set<Game> findOneByRoundAndTournament_IdAndBlackIsNull(int round, long tournament_id);
    }
