package tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tournament.model.Game;
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
    public Game findOneByRoundAndGameNumberAndTournament_Id(int round, int gameNumber, long tournament_id){
        return gameService.findOneByRoundAndGameNumberAndTournament_Id(round, gameNumber, tournament_id);
    }
}
