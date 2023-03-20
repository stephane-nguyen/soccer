package com.graphql.soccerDetails.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
    public Footballer createFootballer(Footballer Footballer) {
        log.info("Creating a footballer player");
        return this.footballerRepository.save(Footballer);
    }

    /**
     * TODO
     * @param footballer
     * @return
     */
    @Override
    public Footballer updateFootballer(Footballer footballer){
        log.info("");
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
