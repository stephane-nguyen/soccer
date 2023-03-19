package com.graphql.soccerDetails.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.soccerDetails.constant.SoccerPlayerRoleEnum;
import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.repository.SoccerPlayerRepository;
import com.graphql.soccerDetails.service.SoccerPlayerService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SoccerPlayerServiceImpl implements SoccerPlayerService {

    @Autowired
    private final SoccerPlayerRepository soccerPlayerRepository;

    @Override
    public SoccerPlayer createSoccerPlayer(SoccerPlayer soccerPlayer) {
        return this.soccerPlayerRepository.save(soccerPlayer);
    }

    @Override
    public List<SoccerPlayer> getSoccers() {
        log.info("Fetching all soccers");
        return this.soccerPlayerRepository.findAll();
    }

    @Override
    public SoccerPlayer getSoccerPlayerById(Long id) {
        log.info("Fetching soccer by id : {}", id);
        return this.soccerPlayerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soccer Player not found"));
    }

    private List<SoccerPlayer> filterSoccerPlayersByRole(SoccerPlayerRoleEnum role) {
        List<SoccerPlayer> allSoccerPlayers = this.soccerPlayerRepository.findAll();
        List<SoccerPlayer> filteredSoccerPlayers = allSoccerPlayers.stream()
                .filter(soccerPlayer -> soccerPlayer.getRole().equals(role))
                .collect(Collectors.toList());
        return filteredSoccerPlayers;
    }

    @Override
    public List<SoccerPlayer> getStrikers() {
        return filterSoccerPlayersByRole(SoccerPlayerRoleEnum.ST);
    }

    @Override
    public List<SoccerPlayer> getGoalkeepers() {
        return filterSoccerPlayersByRole(SoccerPlayerRoleEnum.GK);
    }

}
