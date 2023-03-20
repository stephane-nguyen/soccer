package com.graphql.soccerDetails.model;

import com.graphql.soccerDetails.constant.FootballerAttributesEnum;
import com.graphql.soccerDetails.constant.FootballerRoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne
    @JoinColumn(name = "club_id", referencedColumnName = "id")
    @Column(name = "club", nullable = false)
    private Club club;
}
