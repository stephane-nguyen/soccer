package com.graphql.soccerDetails.service;

import static org.mockito.Mockito.verify;

import com.graphql.soccerDetails.model.ClubInput;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.model.FootballerStats;
import com.graphql.soccerDetails.service.impl.ClubServiceImpl;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.constant.FootballerRoleEnum;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClubServiceTest {

    static Club club;
    static ClubInput clubInput;
    static FootballerStats footballerStats;
    @Mock
    private ClubRepository clubRepository;
    private ClubServiceImpl clubService;

    @BeforeEach
    void setUp() {
        clubService = new ClubServiceImpl(clubRepository);
        club = new Club(2L, "FC Barcelona", "Spain", "Barcelona", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
        footballerStats = new FootballerStats(10,10,10,10,10,10);

        Footballer footballer = new Footballer(null, "Lionel", "Messi", FootballerRoleEnum.ST,
                footballerStats, 93, 34, 25000000, 1.70f, "Argentina", club);
    }

    @AfterAll
    public void endTest() {
        System.out.println("End of the Test");
    }

    @Test
    @Disabled
    @DisplayName("Success adding a club")
    void testAddClub() {
        clubService.createClub(clubInput);
        verify(clubRepository).save(club);
    }

    @Test
    @DisplayName("Success of fetching all clubs")
    void testClubs() {
        clubService.getClubs();
        verify(clubRepository).findAll();
    }

    @Test
    @Disabled
    @DisplayName("Success of fetching a club by its id")
    void testClubById() {
        System.out.println("Before save: " + clubRepository.findAll());
        clubRepository.save(club);
        System.out.println("After save: " + clubRepository.findAll());
        clubService.getClubById(club.getId());
        verify(clubRepository).findById(club.getId());
    }

}
