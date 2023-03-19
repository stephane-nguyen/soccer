package com.graphql.soccerDetails.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int numberOfTrophy;
    private String coach;
    private List<SoccerPlayer> soccerPlayers = new ArrayList<>();
}
