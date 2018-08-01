package tournament.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Tournament {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "tournament")
    private Set<Game> games;
    @ManyToOne
    private User owner;
    private String winner;
    private Long MaxPop;
    private String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "tournament_participant",
            joinColumns = { @JoinColumn(name = "tournament_id") },
            inverseJoinColumns = { @JoinColumn(name = "participant_id") })
    private Set<Participant> participants;

    public Long getId() {
        return id;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Long getMaxPop() {
        return MaxPop;
    }

    public void setMaxPop(Long maxPop) {
        MaxPop = maxPop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }
}
