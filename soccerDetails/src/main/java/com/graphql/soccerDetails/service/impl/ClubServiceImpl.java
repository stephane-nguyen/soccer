package com.graphql.soccerDetails.service.impl;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.ClubInput;
import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<Club> getClubById(Long id) {
        log.info("Fetching club by id : {}", id);
        return Optional.ofNullable(this.clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Club id not found")));
    }

    /**
     * TODO: exception when stadium not found
     * @param stadium string
     * @return Club's stadium name
     */
    @Override
    public Club getClubByStadium(String stadium){
        log.info("fetching a club by its stadium's name : {}", stadium);
        return this.clubRepository.findByStadium(stadium);
    }

    @Override
    public Club getClubByName(String name){
        log.info("fetching a club by its name {}", name);
        return this.clubRepository.findByName(name);
    }

    @Override
    public Club createClub(ClubInput club) {
        log.info("creating the club : {}", club);
        return this.clubRepository.save(new Club(club.getName(), club.getStadium(), club.getLeague()));
    }

    /**
     * TODO
     * @param club
     * @return
     */
    @Override
    public Club updateClub(Club club){
        log.info("updating club");
        return null;
    }

    @Override
    public void deleteClub(Long id){
        log.info("deleting club ID : {}", id);
        this.clubRepository.deleteById(id);;
    }


}

