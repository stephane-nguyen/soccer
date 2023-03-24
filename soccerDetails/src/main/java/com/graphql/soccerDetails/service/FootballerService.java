package com.graphql.soccerDetails.service;

import java.util.List;

import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.model.FootballerInput;
import com.graphql.soccerDetails.model.FootballerStats;

public interface FootballerService {

    public List<Footballer> getFootballers();
    public List<Footballer> getAttackers();
    public List<Footballer> getMidfielders();
    public List<Footballer> getDefenders();

    public List<Footballer> getStrikers();

    public List<Footballer> getGoalkeepers();

    public Footballer getFootballerById(Long footballerId);

    public Footballer createFootballer(FootballerInput footballerInput);

    public void updateFootballerStats(Long id, FootballerStats stats);
    public void deleteFootballer(Long footballerId);
}
