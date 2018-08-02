package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Participant;

import java.util.Set;

@Repository
public interface  ParticipantRepository extends CrudRepository<Participant,Long> {
Set<Participant> findAllByMail(String mail);
Set<Participant> findAllBy();
Set<Participant> findAllByNick(String nick);


}
