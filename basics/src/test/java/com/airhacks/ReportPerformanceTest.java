/*
 */
package com.airhacks;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ReportPerformanceTest {

    private ScriptEngineManager sm;
    private ScriptEngine se;

    @Before
    public void init() {
        this.sm = new ScriptEngineManager();
        this.se = this.sm.getEngineByName("javascript");
        System.out.println("this.se = " + this.se);
    }


    @Test
    public void inMemoryQuery() {
        List<Sample> result = fromDB().stream().filter(this.dynamic()).collect(Collectors.toList());
        System.out.println("result = " + result);

    }

    public List<Sample> fromDB() {
        return Arrays.asList(new Sample("duke", 1), new Sample("daytona", 2), new Sample("nuke", 42)
            );
    }

    public Predicate<Sample> compileTime() {
        return s -> s.getName().startsWith("d");
    }

    public Predicate<Sample> dynamic() {

        Invocable invocable = (Invocable) this.se;

        try {
            this.se.put("THS", 5);
            this.se.put("calc", new Calculation());
            this.se.eval("function test(s){return s.getAge() > calc.result(); }");
        } catch (ScriptException ex) {
            Logger.getLogger(ReportPerformanceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invocable.getInterface(Predicate.class);
    }



}
