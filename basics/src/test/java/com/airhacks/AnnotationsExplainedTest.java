/*
 */
package com.airhacks;

import java.util.Optional;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class AnnotationsExplainedTest {

    @Test
    public void readClassAnnotation() {
        Optional.ofNullable(SoptimMicroservice.class.getAnnotation(SoptimPath.class)).
                ifPresent(this::print);
    }

    void print(SoptimPath path) {
        System.out.println("--  " + path.path());
    }

}
