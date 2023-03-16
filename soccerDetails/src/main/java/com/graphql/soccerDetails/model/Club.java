package com.graphql.soccerDetails.model;

import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Club {
    private int id;
    private String name;
    private String country;
    private String league;
    private String stadium;
    private int numberOfTrophy;
    private String coach;
    private String[] soccerPlayers;

    private static List<Club> Clubs = Arrays.asList(
            Club.builder().id(1).name("FC Barcelone").league("La Liga").build());

    public static Club getById(int id) {
        return Clubs.stream().filter(club -> Integer.valueOf(club.getId()).equals(id))
                .findFirst().orElse(null);
    }
}
