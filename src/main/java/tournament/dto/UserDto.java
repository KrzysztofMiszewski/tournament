package tournament.dto;

import tournament.model.User;

public class UserDto {

    private String login;

    public UserDto(String login) {
        this.login = login;
    }

    public UserDto(User user){
    this.login = user.getLogin();
    }

    public String getLogin(){
        return login;
    }
    }
