package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.constants.Constants;
import tournament.dto.WinnerParams;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.repository.GameRepository;
import tournament.service.GameService;

@RestController
@RequestMapping ("/api/game")
public class GameController {

   private GameService gameService;

   @Autowired
   public GameController (GameService gameService) {
       this.gameService = gameService;
   }

   @PostMapping
   public Game showCurrentGame(int round, int gameNumber, long tournament_id) {
        return gameService.findOneByRoundAndGameNumberAndTournament_Id(round, gameNumber, tournament_id);
   }

   @GetMapping("/find")
   public Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id){
        return gameService.findOneByRoundAndGameNumberAndTournament_Id(round, gameNumber, tournament_id);
   }

   @PutMapping("/setWinner")
   public void setWinner(@RequestBody WinnerParams winner) {
       if (winner.getName() != Constants.WILDCARD)
           gameService.setWinner(winner.getName(), winner.getGame(), winner.getRound(), winner.getTournamentId());
   }

   @PutMapping("/winner")
   public void selectWinner(@RequestParam Long gameId, @RequestParam Long winnerId) {
        gameService.selectWinner(gameId, winnerId);
   }
}
