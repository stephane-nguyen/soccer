package com.graphql.soccerDetails.controller;

import com.graphql.soccerDetails.model.Club;
import com.graphql.soccerDetails.service.ClubService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@Import(ClubService.class)
@GraphQlTest(ClubController.class)
public class ClubControllerTest {
    @Autowired
    GraphQlTester graphQlTester;

    @Test
    void clubsTest(){
        String document = """
               query {
                 clubs {
                   id
                   name
                   city
                   country
                   league
                   stadium
                   numberOfTrophy
                   coach
                   footballers {
                     id
                     firstname
                     lastname
                     role
                     attributes
                     score
                     age
                     salary
                     height
                     nationality
                   }
                 }
               }
                """;
        graphQlTester.document(document)
                .execute()
                .path("clubs")
                .entityList(Club.class)
                .isNotEqualTo(1);
    }
}
