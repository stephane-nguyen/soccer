package com.graphql.soccerDetails.service.impl;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ClubServiceImpl implements ClubService {

    @Autowired
    private final ClubRepository clubRepository;

    @Override
    public List<Club> getClubs(){
        log.info("Fetching all clubs");
        return this.clubRepository.findAll();
    }

    @Override
    public Club getClubById(Long id) {
        log.info("Fetching soccer by id : {}", id);
        return this.clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club not found"));
    }

    /**
     * TODO: exception when stadium not found
     * @param stadium
     * @return Club's stadium name
     */
    @Override
    public Club getClubByStadium(@Argument String stadium){
        log.info("fetch a club by its stadium : {}", stadium);
        return this.clubRepository.findByStadium(stadium);

    }

}

