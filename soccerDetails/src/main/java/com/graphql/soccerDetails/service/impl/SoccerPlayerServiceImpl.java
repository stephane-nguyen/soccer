package com.graphql.soccerDetails.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.soccerDetails.constant.SoccerPlayerRoleEnum;
import com.graphql.soccerDetails.model.SoccerPlayer;
import com.graphql.soccerDetails.repository.SoccerPlayerRepository;
import com.graphql.soccerDetails.service.SoccerPlayerService;

@Service
@Transactional
public class SoccerPlayerServiceImpl implements SoccerPlayerService {
    private final SoccerPlayerRepository soccerPlayerRepository;

    public SoccerPlayerServiceImpl(SoccerPlayerRepository soccerPlayerRepository) {
        this.soccerPlayerRepository = soccerPlayerRepository;
    }

    @Override
    public List<SoccerPlayer> getSoccers() {
        return this.soccerPlayerRepository.findAll();
    }

    // @Override
    // public List<SoccerPlayer> getStrikers() {
    // List<SoccerPlayer> allSoccerPlayers = this.soccerPlayerRepository.findAll();
    // List<SoccerPlayer> strikers = allSoccerPlayers.stream()
    // .filter(soccerPlayer ->
    // soccerPlayer.getRole().equals(soccerPlayerRoleEnum.ST))
    // .collect(Collectors.toList());
    // return strikers;
    // }

    // @Override
    // public List<SoccerPlayer> getGoalkeepers() {
    // List<SoccerPlayer> allSoccerPlayers = this.soccerPlayerRepository.findAll();
    // List<SoccerPlayer> goalkeepers = allSoccerPlayers.stream()
    // .filter(soccerPlayer ->
    // soccerPlayer.getRole().equals(soccerPlayerRoleEnum.GK))
    // .collect(Collectors.toList());
    // return goalkeepers;
    // }

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

    @Override
    public SoccerPlayer getSoccerPlayerById(int id) {
        return this.soccerPlayerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Soccer Player not found"));
    }
}
