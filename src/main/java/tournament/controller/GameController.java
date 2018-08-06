package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.model.Game;
import tournament.model.Participant;
import tournament.repository.GameRepository;
import tournament.service.GameService;

@RestController
@RequestMapping ("/api/game")
public class GameController {

   private GameService gameService;
   private GameRepository gameRepository;

   @Autowired
   public GameController (GameService gameService) {
       this.gameService = gameService;
   }

   @PostMapping
   public Game showCurrentGame(int round, int gameNumber, long tournament_id) {
        return gameService.findOneByRoundAndGameNumberAndTournament_Id(round, gameNumber, tournament_id);
   }

   @GetMapping
   public void create (@RequestParam Long tournamentId, @RequestParam int round, @RequestParam int gameNumber){
        gameService.create(tournamentId, round, gameNumber);
   }

   @GetMapping("/find")
   public Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id){
        return gameService.findOneByRoundAndGameNumberAndTournament_Id(round, gameNumber, tournament_id);
   }

   @PutMapping("/winner")
   public void selectWinner(@RequestParam Long gameId, @RequestParam Long winnerId) {
        gameService.selectWinner(gameId, winnerId);
   }
}
