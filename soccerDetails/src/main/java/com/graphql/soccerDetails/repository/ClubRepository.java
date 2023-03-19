package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.soccerDetails.model.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {
}
