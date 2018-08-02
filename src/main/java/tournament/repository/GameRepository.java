package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;

@Repository
public interface GameRepository extends CrudRepository <Game, Long> {
      Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id);
    }
