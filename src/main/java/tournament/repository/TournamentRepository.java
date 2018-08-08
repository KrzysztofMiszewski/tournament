package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.Tournament;
import tournament.model.User;

import java.util.Set;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {

    Set<Tournament> findAllBy();
    Set<Tournament> findAllByIsStartedIsFalse();
    Tournament findOneById(Long id);
    Set<Tournament> findAllByOwnerId(Long id);

}
