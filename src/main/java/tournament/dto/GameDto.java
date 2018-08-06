package tournament.dto;

import tournament.model.Game;
import tournament.model.Participant;

public class GameDto {

    private ParticipantDto white;
    private ParticipantDto black;
    private String winner;
    private int round;
    private int gameNumber;
    private String tournamentName;

    public GameDto(Game game) {
        if (game.getWhite() != null) this.white = new ParticipantDto(game.getWhite());
        if (game.getBlack() != null)this.black = new ParticipantDto(game.getBlack());
        this.gameNumber = game.getGameNumber();
        this.round = game.getRound();
        this.winner = game.getWinner();
        tournamentName = game.getTournament().getName();
    }

    public ParticipantDto getWhite() {
        return white;
    }

    public ParticipantDto getBlack() {
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
