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

    @ManyToOne
    private Participant white;

    @ManyToOne
    private Participant black;
    private String winner;
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

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getGameNumber() {
        return this.gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }
}
