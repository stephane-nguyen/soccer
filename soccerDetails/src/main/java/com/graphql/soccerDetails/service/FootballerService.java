package com.graphql.soccerDetails.service;

import java.util.List;

import com.graphql.soccerDetails.model.Footballer;

public interface FootballerService {

    public List<Footballer> getFootballers();

    public List<Footballer> getStrikers();

    public List<Footballer> getGoalkeepers();

    public Footballer getFootballerById(Long footballerId);

    public Footballer createFootballer(Footballer footballer);

    public Footballer updateFootballer(Footballer footballer);
    public void deleteFootballer(Long footballerId);
}
