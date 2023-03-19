package com.graphql.soccerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.service.SoccerPlayerService;

@Controller
public class SoccerPlayerController {

    @Autowired
    private SoccerPlayerService soccerPlayerService;

    @QueryMapping
    public SoccerPlayer soccerPlayerById(@Argument int id) {
        return soccerPlayerService.getSoccerPlayerById(id);
    }

    @QueryMapping
    public List<SoccerPlayer> soccers() {
        return soccerPlayerService.getSoccers();
    }

}