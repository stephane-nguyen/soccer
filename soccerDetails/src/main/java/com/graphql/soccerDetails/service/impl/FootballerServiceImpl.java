package com.graphql.soccerDetails.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.FootballerInput;
import com.graphql.soccerDetails.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.model.Footballer;
import com.graphql.soccerDetails.repository.FootballerRepository;
import com.graphql.soccerDetails.service.FootballerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FootballerServiceImpl implements FootballerService {

    @Autowired
    private final FootballerRepository footballerRepository;

    @Autowired
    private final ClubServiceImpl clubService;

    @Override
    public List<Footballer> getFootballers() {
        log.info("Fetching all footballers");
        return this.footballerRepository.findAll();
    }


    @Override
    public Footballer getFootballerById(Long id) {
        log.info("Fetching footballer by id : {}", id);
        return this.footballerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Footballer not found"));
    }

    @Override
    public Footballer createFootballer(FootballerInput footballerInput) {
        log.info("Creating the footballer player : {} ", footballerInput);

        //can't use directly ClubInput to respect the Club attribute in Footballer class
        Club club = clubService.getClubByStadium(footballerInput.getClubInput().getStadium());
        Footballer footballer = new Footballer(footballerInput.firstname(), footballerInput.lastname(), club);

        return this.footballerRepository.save(footballer);
    }

    /**
     * TODO
     * @param footballer
     * @return
     */
    @Override
    public Footballer updateFootballer(Footballer footballer){
        log.info("updating footballer {}", footballer);
        return null;
    }

    @Override
    public void deleteFootballer(Long id){
        log.info("deleting footballer ID: {}", id);
        this.footballerRepository.deleteById(id);
    }

    private List<Footballer> filterFootballersByRole(FootballerRoleEnum role) {
        List<Footballer> allFootballers = this.footballerRepository.findAll();
        List<Footballer> filteredFootballers = allFootballers.stream()
                .filter(Footballer -> Footballer.getRole().equals(role))
                .collect(Collectors.toList());
        return filteredFootballers;
    }

    @Override
    public List<Footballer> getStrikers() {
        log.info("Fetching all strikers");
        return filterFootballersByRole(FootballerRoleEnum.ST);
    }

    @Override
    public List<Footballer> getGoalkeepers() {
        log.info("Fetching all goalkeepers");
        return filterFootballersByRole(FootballerRoleEnum.GK);
    }


}
