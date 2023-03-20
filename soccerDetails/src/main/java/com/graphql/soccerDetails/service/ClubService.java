package com.graphql.soccerDetails.service;

import com.graphql.soccerDetails.model.Club;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

public interface ClubService {
    public List<Club> getClubs();

    public Club getClubById(@Argument Long clubId);

    public Club getClubByStadium(@Argument String stadium);

    public Club createClub(Club club);
}
