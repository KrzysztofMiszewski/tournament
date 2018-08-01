package tournament.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    private Participant white;
    private Participant black;
    private Participant winner;
    private int round;
    private int gameNumber;

    @ManyToOne
    private Tournament tournament;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Long getId() {
        return id;

    }

    public Participant getWhite() {
        return white;
    }

    public void setWhite(Participant white) {
        this.white = white;
    }

    public Participant getBlack() {
        return black;
    }

    public void setBlack(Participant black) {
        this.black = black;
    }

    public Participant getWinner() {
        return winner;
    }

    public void setWinner(Participant winner) {
        this.winner = winner;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
}
