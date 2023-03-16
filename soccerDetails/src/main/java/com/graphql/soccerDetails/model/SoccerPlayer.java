package com.graphql.soccerDetails.model;

import java.util.Arrays;
import java.util.List;

import com.graphql.soccerDetails.constant.soccerPlayerRoleEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SoccerPlayer {
    private int id;
    private String firstname;
    private String lastname;
    private soccerPlayerRoleEnum role;
    private int score;
    private int age;
    private String nationality;
    private int clubId;

    private static List<SoccerPlayer> SoccerPlayers = Arrays.asList(
            SoccerPlayer.builder().id(1).firstname("Lionel").role(soccerPlayerRoleEnum.RW).lastname("Messi").clubId(1)
                    .score(95).build());

    public static SoccerPlayer getById(int id) {
        return SoccerPlayers.stream().filter(soccerPlayer -> Integer.valueOf(soccerPlayer.getId()).equals(id))
                .findFirst().orElse(null);
    }

}
