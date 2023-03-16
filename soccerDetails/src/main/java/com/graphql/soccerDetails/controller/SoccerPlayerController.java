package com.graphql.soccerDetails.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.SoccerPlayer;

@Controller
public class SoccerPlayerController {
    @QueryMapping
    public SoccerPlayer SoccerPlayerById(@Argument int id) {
        return SoccerPlayer.getById(id);
    }

    @SchemaMapping
    public Club club(SoccerPlayer soccerPlayer) {
        return Club.getById(soccerPlayer.getClubId());
    }
}