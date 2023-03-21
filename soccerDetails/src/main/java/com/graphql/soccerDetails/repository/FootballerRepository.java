package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.graphql.soccerDetails.model.Footballer;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {
}
