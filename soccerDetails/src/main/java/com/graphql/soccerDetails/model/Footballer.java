package com.graphql.soccerDetails.model;

import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.utils.MathUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Footballer")
@Table
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private FootballerRoleEnum role;

    @Embedded
    @Column(name = "stats", nullable = false)
    private FootballerStats stats;

    @Column(name = "score", columnDefinition = "int default 0")
    private int score;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @Column(name = "height")
    private float height;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_club", referencedColumnName = "id")
    private Club club;

    public Footballer(String firstname, String lastname, Club club) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.club = club;
    }

    public void setScore(FootballerStats footballerStats) {
        this.score = calculateScore(footballerStats);
    }

    private int calculateScore(FootballerStats footballerStats) {

        ArrayList<Integer> allStats = new ArrayList<>();
        allStats.add(footballerStats.getPace());
        allStats.add(footballerStats.getShooting());
        allStats.add(footballerStats.getPassing());
        allStats.add(footballerStats.getDribbling());
        allStats.add(footballerStats.getDefence());
        allStats.add(footballerStats.getPhysical());

        return MathUtils.mean(allStats);
    }

}
