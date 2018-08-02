package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import tournament.model.Participant;

import java.util.Set;

public interface  ParticipantRepository extends CrudRepository<Participant,Long> {
Set<Participant> findAllByMail(String mail);
Set<Participant> findAllBy();
Set<Participant> findAllByNick(String nick);


}
