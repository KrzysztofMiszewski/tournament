package tournament.service;

import org.springframework.stereotype.Service;
import tournament.model.User;

import java.util.Set;

@Service
public interface UserService {

    Set<User> findAll();
    Set<User> findByLogin(String Login);
    Set<User> findOneById(Long id);
    void create(String login, String password);
    User logIn(User user);
}
