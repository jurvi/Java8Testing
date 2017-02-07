package com.jjarvela;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jjarvela on 11/01/17.
 */
public class ToStreamConversions {

    @Test
    public void arrayToStream() {
        String[] languages = { "JavaScript", "Java", "Cobol", "CSharp" };
        Stream<String> stream = Arrays.stream(languages);

        long longerThanFiveCount = stream.filter(
            lang -> lang.length() > 5).count();

        assertEquals(2, longerThanFiveCount);
    }

    @Test
    public void listToStream() {
        List<String> languages = new ArrayList<>();
        languages.add("JavaScript");
        languages.add("Java");
        languages.add("Cobol");
        languages.add("CSharp");

        long startsWithCCount = languages.stream().filter(
            lang -> lang.startsWith("C")).count();
        assertEquals(2, startsWithCCount);

    }
}
