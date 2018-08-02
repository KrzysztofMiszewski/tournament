package tournament.service;

import tournament.model.Tournament;
import tournament.model.User;

import java.util.Set;

public interface TournamentService {

    Set<Tournament> findAllBy();
    Set<Tournament> findAllByIsStartedIsFalse();
    Boolean isStarted(Tournament tournament);
    Tournament create(User user, Integer maxPop, String Name);
    void start(Tournament tournament);
}
