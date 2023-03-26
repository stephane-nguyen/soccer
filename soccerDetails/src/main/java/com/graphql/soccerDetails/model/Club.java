package com.graphql.soccerDetails.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Club")
@Table
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "league")
    private String league;

    @Column(name = "stadium", unique = true)
    private String stadium;

    @Column(name = "number_of_trophy")
    private int numberOfTrophy;

    @Column(name = "coach")
    private String coach;

    @OneToMany
    @JoinColumn(name = "fk_club")
    private List<Footballer> footballers = new ArrayList<>();

    // For addClub with arguments of ClubInput
    public Club(String name, String stadium, String league) {
        this.name = name;
        this.stadium = stadium;
        this.league = league;
    }
}
