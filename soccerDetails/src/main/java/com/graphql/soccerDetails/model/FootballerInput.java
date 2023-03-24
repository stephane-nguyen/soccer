package com.graphql.soccerDetails.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FootballerInput{
    private String firstname;
    private String lastname;
    private ClubInput clubInput;
}