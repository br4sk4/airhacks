/*
 */
package com.airhacks;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ReportPerformanceTest {

    @Test
    public void inMemoryQuery() {
        double average = fromDB().stream().filter(s -> s.getName().startsWith("d")).
                mapToInt(s -> s.getAge()).
                average().
                orElse(0);
        System.out.println("average = " + average);

    }

    public List<Sample> fromDB() {
        return Arrays.asList(new Sample("duke", 1), new Sample("daytona", 2), new Sample("nuke", 42)
            );
    


    }

}
