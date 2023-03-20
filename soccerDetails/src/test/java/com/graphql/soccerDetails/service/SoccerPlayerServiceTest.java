package com.graphql.soccerDetails.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import com.graphql.soccerDetails.constant.SoccerPlayerAttributesEnum;
import com.graphql.soccerDetails.constant.SoccerPlayerRoleEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.repository.SoccerPlayerRepository;

import com.graphql.soccerDetails.service.impl.SoccerPlayerServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SoccerPlayerServiceTest {
    static SoccerPlayer soccerPlayer;

    @Mock
    private SoccerPlayerRepository soccerPlayerRepository;
    private SoccerPlayerServiceImpl soccerPlayerService;

    @BeforeEach
    void setUp() {
        soccerPlayerService = new SoccerPlayerServiceImpl(soccerPlayerRepository);
        Club club1 = new Club(null, "FC Barcelona", "Spain", "Barcelona", "La Liga", "Camp Nou", 91, "Ronald Koeman", null);
        soccerPlayer = new SoccerPlayer(1L, "Lionel", "Messi", SoccerPlayerRoleEnum.ST,
                SoccerPlayerAttributesEnum.SHO, 93.0f, 34, 25000000, 1.70f, "Argentina", club1);
    }

    @AfterAll
    public void endTest() {
        System.out.println("End of the Test");
    }

    @Test
    @DisplayName("Success of adding a soccer player ")
    void testCreateSoccerPlayer() {
        soccerPlayerService.createSoccerPlayer(soccerPlayer);
        verify(soccerPlayerRepository).save(soccerPlayer);
    }

    @Test
    @DisplayName("Success of fetching all soccers")
    void testGetSoccers() {
        soccerPlayerService.getSoccers();
        verify(soccerPlayerRepository).findAll();
    }


    @Test
    @DisplayName("Success of fetching a soccer by its id")
    void testSoccerById() {
        soccerPlayerService.getSoccerPlayerById(soccerPlayer.getId());
        verify(soccerPlayerRepository).findById(soccerPlayer.getId());
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


