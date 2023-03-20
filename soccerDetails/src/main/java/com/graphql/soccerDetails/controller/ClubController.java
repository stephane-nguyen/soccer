package com.graphql.soccerDetails.controller;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.service.ClubService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClubController {

    @Autowired
    public ClubService clubService;

    @QueryMapping
    public List<Club> clubs() {
        return clubService.getClubs();
    }

    @QueryMapping
    public Club clubById(@Argument Long id){
        return clubService.getClubById(id);
    }

    @QueryMapping
    public Club clubByStadium(@Argument String stadium){ return clubService.getClubByStadium(stadium);}

    @MutationMapping
    public Club addClub(@Argument Club club){
        return clubService.createClub(club);
    }

    @MutationMapping
    public void deleteClubById(@Argument Long id){
        clubService.deleteClub(id);
    }
}

@Getter
@Setter
class ClubInput{
    private String name;
    private String city;
    private String league;
}
