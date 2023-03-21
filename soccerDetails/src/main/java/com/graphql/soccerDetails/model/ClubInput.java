package com.graphql.soccerDetails.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public record ClubInput(String name, String stadium, String league){
}

