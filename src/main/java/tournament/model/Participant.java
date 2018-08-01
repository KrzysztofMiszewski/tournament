package tournament.model;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Participant {
    @Id
    @GeneratedValue
    private Long Id;

    @Column(unique = true)
    private String mail;

    private String nick;

    @ManyToMany(mappedBy = "participants")
    private Set<Tournament> tournaments;

    public Long getId() {
        return Id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }


}
