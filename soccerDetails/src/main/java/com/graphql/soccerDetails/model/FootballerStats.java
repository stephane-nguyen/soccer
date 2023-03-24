package com.graphql.soccerDetails.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter
@Setter
public class FootballerStats {
    private int pace;
    private int shooting;
    private int passing;
    private int dribbling;
    private int defence;
    private int physical;
}