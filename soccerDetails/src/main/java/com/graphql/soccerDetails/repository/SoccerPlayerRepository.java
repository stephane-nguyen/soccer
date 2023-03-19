package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.graphql.soccerDetails.model.SoccerPlayer;

public interface SoccerPlayerRepository extends JpaRepository<SoccerPlayer, Long> {
}
