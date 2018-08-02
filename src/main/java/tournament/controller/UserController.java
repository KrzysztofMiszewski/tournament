package tournament.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.model.User;
import tournament.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

        private UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
    }
        @GetMapping
        public Set<User> findAll() {
            return userService.findAll();
        }
        @GetMapping("/2")
        public Set<User> findByLogin(@PathVariable String login){
                return userService.findByLogin(login);
        }
        @GetMapping("/3")
        public Set<User> findOneById(@PathVariable Long id){
            return userService.findOneById(id);
        }
        @PostMapping
        public void createNewUser(@PathVariable String login,
                                  @PathVariable String password){
            userService.create(login, password);

        }

}
