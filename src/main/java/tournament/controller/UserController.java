package tournament.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tournament.dto.ParticipantDto;
import tournament.dto.UserDto;
import tournament.model.User;
import tournament.service.UserService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

        private UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
    }
        @GetMapping
        public Set<UserDto> findAll() {
            return userService.findAll().stream().map(UserDto::new).collect(Collectors.toSet());
        }
        @GetMapping("/2")
        public Set<User> findByLogin(@PathVariable String login){
                return userService.findByLogin(login);
        }
        @GetMapping("/3")
        public User findOneById(@PathVariable Long id){
            return userService.findOneById(id);
        }
        @PostMapping("/new/{login}/{password}")
        public void createNewUser(@PathVariable String login,
                                  @PathVariable String password){
            userService.create(login, password);

        }

}
