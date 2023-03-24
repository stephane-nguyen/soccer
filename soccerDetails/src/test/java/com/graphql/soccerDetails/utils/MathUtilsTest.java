package com.graphql.soccerDetails.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {

    @Test
    @DisplayName("Success calculating the mean and round it")
    public void meanTest(){
        ArrayList<Integer> values = new ArrayList<>();
        values.add(3);
        values.add(4);
        values.add(2);
        values.add(3);
        assertEquals(3, MathUtils.mean(values));
        values.add(1);
        assertEquals(3, MathUtils.mean(values));
    }

}
