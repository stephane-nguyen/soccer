package com.graphql.soccerDetails.service;

import java.util.List;

import com.graphql.soccerDetails.model.Footballer;

public interface FootballerService {

    List<Footballer> getFootballers();

    List<Footballer> getStrikers();

    List<Footballer> getGoalkeepers();

    Footballer getFootballerById(Long FootballerId);

    Footballer createFootballer(Footballer Footballer);
}
