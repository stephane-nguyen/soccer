package com.graphql.soccerDetails.service;

import static org.mockito.Mockito.verify;

import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.service.impl.ClubServiceImpl;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.constant.FootballerAttributesEnum;

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
        Footballer Footballer = new Footballer(null, "Lionel", "Messi", FootballerRoleEnum.ST,
                FootballerAttributesEnum.SHO, 93.0f, 34, 25000000, 1.70f, "Argentina", club);
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
    void testFootballerById() {
        clubService.getClubById(club.getId());
        verify(clubRepository).findById(club.getId());
    }

    // @Test
    // @Disabled
    // void testDeleteFootballer() {
    // FootballerService.deleteFootballer(Footballer.getIdFootballer());
    // verify(FootballerRepository).deleteById(Footballer.getIdFootballer());
    // }



    // @Test
    // @Disabled
    // void testUpdateFootballer() {
    // FootballerService.updateFootballer(Footballer);
    // verify(FootballerRepository).save(Footballer);
    // }

}
