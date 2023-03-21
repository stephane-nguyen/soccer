package com.graphql.soccerDetails.model;

import com.graphql.soccerDetails.constant.FootballerAttributesEnum;
import com.graphql.soccerDetails.constant.FootballerRoleEnum;

import com.graphql.soccerDetails.repository.ClubRepository;
import com.graphql.soccerDetails.service.impl.ClubServiceImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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

    @Column(name = "attribute", nullable = false)
    private FootballerAttributesEnum attribute;

    @Column(name = "score", nullable = false)
    private float score; // TODO: mean of attributes in utils

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "salary")
    private int salary;

    @Column(name = "height", nullable = false)
    private float height;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    private Club club;

    public Footballer(String firstname, String lastname, Club club){
        this.firstname=firstname;
        this.lastname=lastname;
        this.club= club;
    }
}
