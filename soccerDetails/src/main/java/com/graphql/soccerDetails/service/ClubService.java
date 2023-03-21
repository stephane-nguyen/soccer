package com.graphql.soccerDetails.service;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.ClubInput;
import org.springframework.graphql.data.method.annotation.Argument;

import java.util.List;

public interface ClubService {
    public List<Club> getClubs();

    public Club getClubById(Long clubId);

    public Club getClubByStadium(String stadium);
    public Club getClubByName(String name);

    public Club createClub(ClubInput clubInput);

    public void deleteClub(Long id);

    public Club updateClub(Club club);
}
