package com.graphql.soccerDetails.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
    @SequenceGenerator(name = "club_sequence", sequenceName = "club_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_sequence")

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name = "league")
    private String league;

    @Column(name = "stadium", unique = true)
    private String stadium;

    @Column(name = "numberOfTrophy")
    private int numberOfTrophy;

    @Column(name = "coach")
    private String coach;

    @OneToMany(mappedBy = "club")
    @Column(name = "footballers", nullable = false)
    private List<Footballer> footballers = new ArrayList<>();

    //For addClub with arguments of ClubInput
    public Club(String name, String stadium, String league){
        this.name = name;
        this.stadium = stadium;
        this.league = league;
    }
}
