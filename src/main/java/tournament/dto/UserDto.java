package tournament.dto;

import tournament.model.User;

public class UserDto {

    private Long id;
    private String login;
    private String password;

    public UserDto(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public UserDto(User user){
    this.id = user.getId();
    this.login = user.getLogin();
    this.password = user.getPassword();
    }

    public Long getId(){
        return id;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }


}
