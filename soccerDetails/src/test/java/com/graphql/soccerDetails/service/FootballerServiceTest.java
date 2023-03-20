package com.graphql.soccerDetails.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import com.graphql.soccerDetails.constant.FootballerAttributesEnum;
import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.repository.FootballerRepository;

import com.graphql.soccerDetails.service.impl.FootballerServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FootballerServiceTest {
    static Footballer Footballer;

    @Mock
    private FootballerRepository footballerRepository;
    private FootballerServiceImpl FootballerService;

    @BeforeEach
    void setUp() {
        FootballerService = new FootballerServiceImpl(footballerRepository);
        Club club1 = new Club(null, "FC Barcelona", "Spain", "Barcelona", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
        Footballer = new Footballer(1L, "Lionel", "Messi", FootballerRoleEnum.ST,
                FootballerAttributesEnum.SHO, 93.0f, 34, 25000000, 1.70f, "Argentina", club1);
    }

    @AfterAll
    public void endTest() {
        System.out.println("End of the Test");
    }

    @Test
    @DisplayName("Success of adding a footballer")
    void testCreateFootballer() {
        FootballerService.createFootballer(Footballer);
        verify(footballerRepository).save(Footballer);
    }

    @Test
    @DisplayName("Success of fetching all footballers")
    void testGetFootballers() {
        FootballerService.getFootballers();
        verify(footballerRepository).findAll();
    }


    @Test
    @DisplayName("Success of fetching a footballer by its id")
    void testFootballerById() {
        FootballerService.getFootballerById(Footballer.getId());
        verify(footballerRepository).findById(Footballer.getId());
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


