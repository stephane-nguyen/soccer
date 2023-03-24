package com.graphql.soccerDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.graphql.soccerDetails.model.Footballer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Long> {
    //List<Footballer> findByStatisticsShootingGreaterThan(int shootingValue);
}
