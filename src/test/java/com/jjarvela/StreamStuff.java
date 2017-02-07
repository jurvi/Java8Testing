package com.jjarvela;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jjarvela on 25/01/17.
 */
public class StreamStuff {

    @Test
    public void setToList() {
        Set<String> stringSet = Stream.of("1", "2", "3", "4").collect(Collectors.toSet());
        List<String> stringList = stringSet.stream().collect(Collectors.toList());

        assertEquals(4, stringList.size());
    }
}
