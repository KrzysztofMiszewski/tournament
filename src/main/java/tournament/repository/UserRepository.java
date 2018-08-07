package tournament.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tournament.model.User;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Set<User> findAll();
    Set<User> findByLogin(String login);
    Set<User> findOneById(Long id);
    User findOneByLogin(String login);
}
