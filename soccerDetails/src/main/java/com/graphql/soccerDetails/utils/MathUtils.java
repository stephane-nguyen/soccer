package com.graphql.soccerDetails.utils;

import java.util.ArrayList;

public class MathUtils {
    public static Integer mean(ArrayList<Integer> values) {
        int res = 0;
        for (Integer element : values) {
            res += element;
        }
        return Math.toIntExact(Math.round((double) res / values.size()));
    }
}
