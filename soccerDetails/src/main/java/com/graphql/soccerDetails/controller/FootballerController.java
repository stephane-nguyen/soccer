package com.graphql.soccerDetails.controller;

import java.util.List;

import com.graphql.soccerDetails.model.FootballerInput;
import com.graphql.soccerDetails.model.FootballerStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.service.FootballerService;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("api/footballer")
public class FootballerController {

    @Autowired
    private FootballerService footballerService;

    @QueryMapping
    public Footballer FootballerById(@Argument Long id) {
        return this.footballerService.getFootballerById(id);
    }

    @QueryMapping
    public List<Footballer> footballers() {
        return this.footballerService.getFootballers();
    }

    @QueryMapping
    public List<Footballer> strikers(){
        return this.footballerService.getStrikers();
    }

    @QueryMapping
    public List<Footballer> goalkeepers() {
        return this.footballerService.getGoalkeepers();
    }

    @MutationMapping
    public Footballer addFootballer(@Argument FootballerInput footballerInput) {
        return this.footballerService.createFootballer(footballerInput);
    }

    @MutationMapping
    public void deleteFootballerById(@Argument Long id){
        this.footballerService.deleteFootballer(id);
    }

    @MutationMapping
    public void updateFootballerStats(@Argument Long id, @Argument FootballerStats stats){
        this.footballerService.updateFootballerStats(stats);
    }

}

