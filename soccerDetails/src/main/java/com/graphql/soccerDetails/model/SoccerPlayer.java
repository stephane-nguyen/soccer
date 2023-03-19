package com.graphql.soccerDetails.model;

import com.graphql.soccerDetails.constant.SoccerPlayerAttributesEnum;
import com.graphql.soccerDetails.constant.SoccerPlayerRoleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SoccerPlayer {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private SoccerPlayerRoleEnum role;
    private SoccerPlayerAttributesEnum attribute;
    private float score; // TODO: mean of attributes in utils
    private int age;
    private int salary;
    private float height;
    private String nationality;
    private int clubId;
}
