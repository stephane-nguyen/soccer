package com.graphql.soccerDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.service.FootballerService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class FootballerController {

    @Autowired
    private FootballerService footballerService;

    @QueryMapping
    public Footballer FootballerById(@Argument Long id) {
        return footballerService.getFootballerById(id);
    }

    @QueryMapping
    public List<Footballer> footballers() {
        return footballerService.getFootballers();
    }

    @QueryMapping
    public List<Footballer> strikers(){
        return footballerService.getStrikers();
    }

    @QueryMapping
    public List<Footballer> goalkeepers() {
        return footballerService.getGoalkeepers();
    }

    @MutationMapping
    public Footballer addFootballer(Footballer footballer) {
        return this.footballerService.createFootballer(footballer);
    }

    @MutationMapping
    public void deleteFootballerById(@Argument Long id){
        this.footballerService.deleteFootballer(id);
    }

}

@Getter
@Setter
class PlayerInput {
    private String firstname;
    private String lastname;
    private Club club;
}