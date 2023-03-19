package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.soccerDetails.model.SoccerPlayer;

@Repository
public interface SoccerPlayerRepository extends JpaRepository<SoccerPlayer, Integer> {
}
