package tournament.dto;

import tournament.model.Game;
import tournament.model.Tournament;

import java.util.Set;
import java.util.stream.Collectors;

public class TournamentDto {

    private GameDto[][] games;
    private UserDto owner;
    private String winner;
    private Integer MaxPop;
    private String name;
    private Set<ParticipantDto> participants;
    private Boolean isStarted = false;

    public TournamentDto(Tournament tournament) {
        this.owner = new UserDto(tournament.getOwner());
        this.winner = tournament.getWinner();
        this.MaxPop = tournament.getMaxPop();
        this.name = tournament.getName();
        this.participants = tournament.getParticipants().stream().map(ParticipantDto::new).collect(Collectors.toSet());
        this.isStarted = tournament.getStarted();
        int rounds = 0;
        for (Game game : tournament.getGames()) {
            if (game.getRound() > rounds) rounds = game.getRound();
        }
        games = new GameDto[rounds][];
        for (int i = 0; i < games.length; i++) {
            games[i] = new GameDto[(int) Math.pow(2, i+1)];
        }
        for (Game game : tournament.getGames()) {
            games[game.getRound()][game.getGameNumber()] = new GameDto(game);
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
        return MaxPop;
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
