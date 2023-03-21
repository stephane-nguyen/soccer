package com.graphql.soccerDetails.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record FootballerInput(String firstname, String lastname, ClubInput clubInput){
}