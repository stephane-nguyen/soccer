package com.graphql.soccerDetails.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.graphql.soccerDetails.constant.FootballerPositionEnum;
import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.model.FootballerInput;
import com.graphql.soccerDetails.model.FootballerStats;
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
        Footballer footballer = new Footballer(footballerInput.getFirstname(), footballerInput.getFirstname(), club);

        return this.footballerRepository.save(footballer);
    }

    @Override
    public void updateFootballerStats(Long id, FootballerStats stats) {
        log.info("Updating footballer stats");

    }

    @Override
    public void deleteFootballer(Long id){
        log.info("deleting footballer ID: {}", id);
        this.footballerRepository.deleteById(id);
    }


    @Override
    public List<Footballer> getAttackers(){
        log.info("Fetching all attackers");
        return null;
    }
    @Override
    public List<Footballer> getMidfielders(){
        log.info("Fetching all midfielders");

        return null;
    }
    @Override
    public List<Footballer> getDefenders(){
        log.info("Fetching all defenders");
        return null;
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

    private List<Footballer> filterFootballersByRole(FootballerRoleEnum role) {
        List<Footballer> allFootballers = this.footballerRepository.findAll();
        return allFootballers.stream()
                .filter(Footballer -> Footballer.getRole().equals(role))
                .collect(Collectors.toList());
    }


    private void regroupRoleInPosition(Footballer footballer){
        if(isAttacker(footballer)){
            System.out.println("o");
        } else if(isMidfielder(footballer)){
            System.out.println("o");
        } else if (isDefender(footballer)){
            System.out.println("o");
        }
    }

    private boolean isAttacker(Footballer footballer){
        return footballer.getRole()==FootballerRoleEnum.LW
                || footballer.getRole()==FootballerRoleEnum.ST
                || footballer.getRole()==FootballerRoleEnum.CF
                || footballer.getRole()==FootballerRoleEnum.RW;
    }
    private boolean isMidfielder(Footballer footballer){
        return footballer.getRole() == FootballerRoleEnum.RM
                || footballer.getRole() == FootballerRoleEnum.CM
                || footballer.getRole() == FootballerRoleEnum.CAM
                || footballer.getRole() == FootballerRoleEnum.CDM
                || footballer.getRole() == FootballerRoleEnum.LM;
    }
    private boolean isDefender(Footballer footballer){
        return footballer.getRole()==FootballerRoleEnum.LM
                || footballer.getRole()==FootballerRoleEnum.RB
                || footballer.getRole()==FootballerRoleEnum.CB
                || footballer.getRole()==FootballerRoleEnum.LB;
    }



}
