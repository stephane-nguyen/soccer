package com.graphql.soccerDetails.service;

import static org.mockito.Mockito.verify;

import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.service.impl.ClubServiceImpl;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.constant.SoccerPlayerRoleEnum;
import com.graphql.soccerDetails.constant.SoccerPlayerAttributesEnum;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClubServiceTest {

    static Club club;
    @Mock
    private ClubRepository clubRepository;
    private ClubServiceImpl clubService;

    @BeforeEach
    void setUp() {
        clubService = new ClubServiceImpl(clubRepository);
        Club club = new Club(null, "FC Barcelona", "Spain", "Barcelona", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
        SoccerPlayer soccerPlayer = new SoccerPlayer(null, "Lionel", "Messi", SoccerPlayerRoleEnum.ST,
                SoccerPlayerAttributesEnum.SHO, 93.0f, 34, 25000000, 1.70f, "Argentina", club);
    }

    @AfterAll
    public void endTest() {
        System.out.println("End of the Test");
    }

    @Test
    @DisplayName("Success adding a club")
    void testAddClub() {
        clubService.createClub(club);
        verify(clubRepository).save(club);
    }

    @Test
    @DisplayName("Success of fetching all clubs")
    void testClubs() {
        clubService.getClubs();
        verify(clubRepository).findAll();
    }

    @Test
    @DisplayName("Success of fetching a club by its id")
    void testSoccerById() {
        clubService.getClubById(club.getId());
        verify(clubRepository).findById(club.getId());
    }

    // @Test
    // @Disabled
    // void testDeleteSoccerPlayer() {
    // SoccerPlayerService.deleteSoccerPlayer(SoccerPlayer.getIdSoccerPlayer());
    // verify(SoccerPlayerRepository).deleteById(SoccerPlayer.getIdSoccerPlayer());
    // }



    // @Test
    // @Disabled
    // void testUpdateSoccerPlayer() {
    // SoccerPlayerService.updateSoccerPlayer(SoccerPlayer);
    // verify(SoccerPlayerRepository).save(SoccerPlayer);
    // }

}
