package com.graphql.soccerDetails.model;

import com.graphql.soccerDetails.constant.FootballerRoleEnum;
import com.graphql.soccerDetails.utils.MathUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import static com.graphql.soccerDetails.utils.MathUtils.mean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Footballer")
@Table
public class Footballer {
    @Id
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")

    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "role", nullable = false)
    private FootballerRoleEnum role;

    @Column(name = "stats", nullable = false)
    @Embedded
    private FootballerStats stats;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "salary")
    private int salary;

    @Column(name = "height", nullable = false)
    private float height;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id", nullable = false)
    private Club club;

    public Footballer(String firstname, String lastname, Club club){
        this.firstname=firstname;
        this.lastname=lastname;
        this.club= club;
    }

    public void setScore(FootballerStats footballerStats){
        this.score = calculateScore(footballerStats);
    }

    private int calculateScore(FootballerStats footballerStats) {

        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(footballerStats.getPace());
        stats.add(footballerStats.getShooting());
        stats.add(footballerStats.getPassing());
        stats.add(footballerStats.getDribbling());
        stats.add(footballerStats.getDefence());
        stats.add(footballerStats.getPhysical());

        return MathUtils.mean(stats);
    }

}
