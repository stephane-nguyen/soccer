package com.graphql.soccerDetails.service;

import static org.mockito.Mockito.verify;

import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.model.FootballerInput;
import com.graphql.soccerDetails.model.FootballerStats;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.repository.FootballerRepository;

import com.graphql.soccerDetails.service.impl.ClubServiceImpl;
import com.graphql.soccerDetails.service.impl.FootballerServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FootballerServiceTest {
    static Footballer footballer;
    static Club club;
    static FootballerStats footballerStats;
    static FootballerInput footballerInput;

    @Mock
    private FootballerRepository footballerRepository;
    private FootballerServiceImpl footballerService;
    private ClubServiceImpl clubService;


    @BeforeEach
    void setUp() {
        footballerService = new FootballerServiceImpl(footballerRepository, clubService);
        footballerStats = new FootballerStats(10,10,10,10,10,10);

        club = new Club(null, "FC Barcelona", "Spain", "Barcelona", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
        footballer = new Footballer(1L, "Lionel", "Messi", FootballerRoleEnum.ST,
                footballerStats, 93, 34, 25000000, 1.70f, "Argentina", club);
    }

    @AfterAll
    public void endTest() {
        System.out.println("End of the Test");
    }

    @Test
    @Disabled
    @DisplayName("Success of adding a footballer")
    void testCreateFootballer() {
        footballerService.createFootballer(footballerInput);
        verify(footballerRepository).save(footballer);
    }

    @Test
    @DisplayName("Success of fetching all footballers")
    void testGetFootballers() {
        footballerService.getFootballers();
        verify(footballerRepository).findAll();
    }


    @Test
    @DisplayName("Success of fetching a footballer by its id")
    void testFootballerById() {
        footballerRepository.save(footballer);
        footballerService.getFootballerById(footballer.getId());
        verify(footballerRepository).findById(footballer.getId());
    }


     @Test
     @DisplayName("Success of deleting a footballer")
     void testDeleteFootballer() {
        footballerService.deleteFootballer(footballer.getId());
        verify(footballerRepository).deleteById(footballer.getId());
     }


     @Test
     @Disabled
     @DisplayName("Success of updating a footballer")
     void testUpdateFootballer() {
        footballerService.updateFootballer(footballer);
        verify(footballerRepository).save(footballer);
     }


}


