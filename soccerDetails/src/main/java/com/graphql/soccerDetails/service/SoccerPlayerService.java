package com.graphql.soccerDetails.service;

import java.util.List;

import com.graphql.soccerDetails.model.SoccerPlayer;

public interface SoccerPlayerService {

    List<SoccerPlayer> getSoccers();

    List<SoccerPlayer> getStrikers();

    List<SoccerPlayer> getGoalkeepers();

    SoccerPlayer getSoccerPlayerById(int soccerPlayerId);
}
