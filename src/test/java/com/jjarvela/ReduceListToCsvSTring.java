package com.jjarvela;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jjarvela on 09/01/17.
 */
public class ReduceListToCsvSTring {

    @Test
    public void listToString() {
        // Set up data
        String movie1 = "Batman";
        String movie2 = "LOTR";
        String movie3 = "Superman";
        String movie4 = "Lego";
        String separator = ",";
        List<String> movies = new LinkedList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        // Expected = Comma separated string
        String expected = movie1 + separator + movie2 + separator + movie3 + separator + movie4;

        // Split the list to comma separated string
        String actual = movies.stream().reduce((t, u) -> t + separator + u).get();

        // Asserts
        assertEquals(expected, actual);
    }
}
