package tournament.dto;

import tournament.model.Game;
import tournament.model.Tournament;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TournamentDto {

    private GameDto[][] games;
    private UserDto owner;
    private String winner;
    private Integer maxPop;
    private String name;
    private Set<ParticipantDto> participants;
    private Boolean isStarted;

    public TournamentDto(Tournament tournament) {
        this.owner = new UserDto(tournament.getOwner());
        this.winner = tournament.getWinner();
        this.maxPop = tournament.getMaxPop();
        this.name = tournament.getName();
        if (tournament.getParticipants() != null) {
            this.participants = tournament.getParticipants().stream().map(ParticipantDto::new).collect(Collectors.toSet());
        }
        this.isStarted = tournament.getStarted();
        if (tournament.getGames() != null) {
            int rounds = 0;
            for (Game game : tournament.getGames()) {
                if (game.getRound() > rounds) rounds = game.getRound();
            }
            rounds++;
            games = new GameDto[rounds][];
            System.out.println("RUNDY: " + games.length);
            for (int i = 0; i < games.length; i++) {
                games[i] = new GameDto[(int) Math.pow(2, i)];
                System.out.println(i + " - GRY: " + games[i].length);
            }
            for (Game game : tournament.getGames()) {
                games[game.getRound()][game.getGameNumber()] = new GameDto(game);
            }
        }
    }

    public GameDto[][] getGames() {
        return games;
    }

    public UserDto getOwner() {
        return owner;
    }

    public String getWinner() {
        return winner;
    }

    public Integer getMaxPop() {
        return maxPop;
    }

    public String getName() {
        return name;
    }

    public Set<ParticipantDto> getParticipants() {
        return participants;
    }

    public Boolean getStarted() {
        return isStarted;
    }
}
