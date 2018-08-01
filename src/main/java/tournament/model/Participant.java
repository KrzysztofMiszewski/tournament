package tournament.model;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;
@Entity
public class Participant {

    private Long Id;
    private String mail;
    private String nick;


    @ManyToMany(mappedBy ="participants")
    private Set< Tournament > tournaments;


}
