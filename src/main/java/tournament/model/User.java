package tournament.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    @OneToMany(mappedBy = "owner")
    private Set<Tournament> tournament;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Tournament> getTournament() {
        return tournament;
    }

    public void setTournament(Set<Tournament> tournament) {
        this.tournament = tournament;
    }
}
