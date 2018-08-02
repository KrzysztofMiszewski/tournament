package tournament.dto;

import tournament.model.Game;
import tournament.model.Participant;

public class GameDto {

    private Participant white;
    private Participant black;
    private String winner;
    private int round;
    private int gameNumber;
    private String tournamentName;

    public GameDto(Game game) {
        this.white = game.getWhite();
        this.black = game.getBlack();
        this.gameNumber = game.getGameNumber();
        this.round = game.getRound();
        this.winner = game.getWinner();
        tournamentName = game.getTournament().getName();
    }

    public Participant getWhite() {
        return white;
    }

    public Participant getBlack() {
        return black;
    }

    public String getWinner() {
        return winner;
    }

    public int getRound() {
        return round;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public String getTournamentName() {
        return tournamentName;
    }
}
