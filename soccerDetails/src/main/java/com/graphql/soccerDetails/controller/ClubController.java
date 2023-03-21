package com.graphql.soccerDetails.controller;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.ClubInput;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.service.ClubService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/club")
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

    @QueryMapping
    public Club clubByName(@Argument String name){ return clubService.getClubByName(name);}

    @MutationMapping
    public Club addClub(@Argument ClubInput clubInput){
        return clubService.createClub(clubInput);
    }

    @MutationMapping
    public void deleteClubById(@Argument Long id){
        clubService.deleteClub(id);
    }

}

