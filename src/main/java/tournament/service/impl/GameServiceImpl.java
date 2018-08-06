package tournament.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.model.Tournament;
import tournament.repository.GameRepository;
import tournament.repository.ParticipantRepository;
import tournament.repository.TournamentRepository;
import tournament.service.GameService;

import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;
    private TournamentRepository tournamentRepository;
    private ParticipantRepository participantRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, TournamentRepository tournamentRepository, ParticipantRepository participantRepository) {
        this.gameRepository = gameRepository;
        this.tournamentRepository = tournamentRepository;
        this.participantRepository = participantRepository;
    }

    @Override
    public Game showCurrentGame(int round, int gameNumber, long tournament_id) {
        return gameRepository.findOneByRoundAndGameNumberAndTournament_Id(round, gameNumber, tournament_id);
    }

    @Override
    public void selectWinner(Long gameId, Long winnerId) {
        if(winnerId == null || gameId == null){
            System.out.println("Id is null");
        }else {
          selectWinner(gameRepository.findOne(gameId),participantRepository.findOne(winnerId));}
    }

    @Override
    @Transactional
    public void selectWinner(Game game, Participant winner) {
        Tournament tournament = game.getTournament();
        if (isFinal(game)) {
            tournament = game.getTournament();
            tournament.setWinner(winner.getNick());
            tournamentRepository.save(tournament);
            game.setWinner(winner.getNick());
            gameRepository.save(game);
        } else {
            game.setWinner(winner.getNick());
            gameRepository.save(game);
            Game nextGame = gameRepository.findOneByRoundAndGameNumberAndTournament_Id(game.getRound()-1,
                    game.getGameNumber()/2, tournament.getId());
            if (game.getGameNumber() % 2 == 0) {
                nextGame.setWhite(winner);
            } else {
                nextGame.setBlack(winner);
            }
            gameRepository.save(nextGame);
        }
    }

    @Override
    public void create(Long tournamentId, int round, int gameNumber) {
        Game game = new Game();

        game.setTournament(tournamentRepository.findOneById(tournamentId));
        game.setGameNumber(gameNumber);
        game.setRound(round);
        gameRepository.save(game);
    }

    @Override
    public  Set<Game> findOneByRoundAndTournament_IdAndBlackIsNull(int round, long tournament_id) {
        return gameRepository.findOneByRoundAndTournament_IdAndBlackIsNull(round, tournament_id);
    }

    @Override
    public Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id) {
        return gameRepository.findOneByRoundAndGameNumberAndTournament_Id(round,gameNumber,tournament_id);
    }

    private boolean isFinal(Game game) {
        return (game.getRound() == 0);
    }
}
