package com.graphql.soccerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.service.SoccerPlayerService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class SoccerPlayerController {

    @Autowired
    private SoccerPlayerService soccerPlayerService;

    @QueryMapping
    public SoccerPlayer soccerPlayerById(@Argument Long id) {
        return soccerPlayerService.getSoccerPlayerById(id);
    }

    @QueryMapping
    public List<SoccerPlayer> soccers() {
        return soccerPlayerService.getSoccers();
    }

    @QueryMapping
    public List<SoccerPlayer> strikers(){
        return soccerPlayerService.getStrikers();
    }

    @QueryMapping
    public List<SoccerPlayer> goalkeepers() {
        return soccerPlayerService.getGoalkeepers();
    }

    @MutationMapping
    public SoccerPlayer addSoccerPlayer(@Argument PlayerInput player) {
        SoccerPlayer newSoccerPlayer = new SoccerPlayer();
        newSoccerPlayer.setFirstname(player.getFirstname());
        newSoccerPlayer.setLastname(player.getLastname());
        newSoccerPlayer.setClub(player.getClub());
        return this.soccerPlayerService.createSoccerPlayer(newSoccerPlayer);
    }

}

@Getter
@Setter
class PlayerInput {
    private String firstname;
    private String lastname;
    private Club club;
}