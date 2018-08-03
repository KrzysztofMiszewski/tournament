package tournament.dto;

import tournament.model.Participant;


public class ParticipantDto {

    private String mail;
    private String nick;

    public ParticipantDto(Participant participant) {
        this.mail = participant.getMail();
        this.nick = participant.getNick();
    }

    public String getMail() {
        return mail;
    }

    public String getNick() {
        return nick;
    }


}
