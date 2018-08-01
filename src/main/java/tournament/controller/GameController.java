package tournament.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tournament.service.GameService;

@RestController
@RequestMapping ("/api/game")
public class GameController {

    GameService gameService;



}
