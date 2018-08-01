package tournament.service.impl;


import tournament.model.User;
import tournament.repository.UserRepository;
import tournament.service.UserService;


import java.util.Set;

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
    public Set<User> findByLogin(String Login) {
        return userRepository.findByLogin(Login);
    }

    @Override
    public void createNewUser(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public User logIn(User user) {
        return userRepository.logIn(user);
    }
}
