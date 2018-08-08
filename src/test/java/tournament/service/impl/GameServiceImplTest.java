package tournament.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import tournament.model.Game;
import tournament.model.Tournament;
import tournament.repository.GameRepository;
import tournament.repository.ParticipantRepository;
import tournament.repository.TournamentRepository;
import tournament.service.GameService;


import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GameServiceImplTest{

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    ParticipantRepository participantRepository;

    @Test
    public void whenGameIsCreated_ThenItCanBeFound() {
        GameService gameService = new GameServiceImpl(gameRepository, tournamentRepository, participantRepository );
        Tournament tournament = new Tournament();
        tournament.setName("Test");
        Tournament save = tournamentRepository.save(tournament);


        gameService.create(save.getId(), 0, 0);

        Game gotFromDb = gameRepository.findOneByRoundAndGameNumberAndTournament_Id(0, 0, save.getId());


        assertThat(gotFromDb)
                .isNotNull();
    }

}
