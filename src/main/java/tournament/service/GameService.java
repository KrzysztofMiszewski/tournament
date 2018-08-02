package tournament.service;

import org.springframework.stereotype.Service;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;

import java.util.Set;

@Service
public interface GameService {

    Game showCurrentGame(int round, int gameNumber, long tournament_id);
    void selectWinner(Game game, Participant winner);
    void create (Long tournamentId, int round, int gameNumber);
    Set<Game> findOneByRoundAndTournament_IdAndBlackIsNull(int round, long tournament_id);
    Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id);
}
