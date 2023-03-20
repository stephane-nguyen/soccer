package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.soccerDetails.model.Club;

public interface ClubRepository extends JpaRepository<Club, Long> {
    public Club findByStadium(String stadium);
}
