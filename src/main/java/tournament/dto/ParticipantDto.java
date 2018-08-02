package tournament.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tournament.model.Participant;

import static tournament.service.ParticipantService.participant;

public class ParticipantDto {
private String mail;
private String nick;

    public ParticipantDto(Participant participant) {
        this.mail = getMail();
        this.nick = getNick();
    }

    public String getMail() {
        return mail;
    }

    public String getNick() {
        return nick;
    }


}
