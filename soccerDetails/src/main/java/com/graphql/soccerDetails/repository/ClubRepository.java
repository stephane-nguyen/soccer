package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.soccerDetails.model.Club;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    public Club findByStadium(String stadium);
    public Club findByName(String name);
}
