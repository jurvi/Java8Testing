package com.jjarvela;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * Created by jjarvela on 09/01/17.
 */
public class ForLoopVsIntStream {

    @Test
    public void loopingNumbers() {
        int start = 0;
        int end = 10;

        // Legacy way
        System.out.println("Legacy way");
        for (int i = start; i < end; i++) {
            System.out.println(i);
        }

        // Fancier way
        System.out.println("Fancy way (non-parallel)");
        IntStream.range(start, end).forEach(
            number -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(number);
                } catch (InterruptedException e) {

                }
            });

        // Fancier way with parallel()
        System.out.println("Fancy way (parallel)");
        IntStream.range(start, end).parallel().forEach(
            number -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(number);
                } catch (InterruptedException e) {

                }
            });
    }
}
