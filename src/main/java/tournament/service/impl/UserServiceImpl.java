package tournament.service.impl;


import org.springframework.stereotype.Service;
import tournament.model.User;
import tournament.repository.UserRepository;
import tournament.service.UserService;


import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Set<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Set<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findOneByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    @Override
    public User findOneById(Long id) {
        List<User> userz = new ArrayList<>(userRepository.findOneById(id));
        return userz.get(0);
    }
    @Override
    public void create(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public User logIn(User user) {
        return user;
    }
}
