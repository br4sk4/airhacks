/*
 */
package com.airhacks.concurrency;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class ConcurrentPipelineTest {

    private ExecutorService tp;

    @Before
    public void init() {
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(5);
        this.tp = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                queue, this::rejectedExecution);
    }

    @Test
    public void concurrentExecution() throws InterruptedException,
            ExecutionException {
        for (int i = 0; i < 10; i++) {
            supplyAsync(this::random, tp).
                    thenApply(this::decorator).
                    thenAccept(this::save).get();

        }
    }

    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Runnable = " + r);
        r.run();
    }

    public String random() {
        return "duke" + System.currentTimeMillis();
    }

    public String decorator(String input) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConcurrentPipelineTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "nice " + input + " --- ";
    }

    public void save(String input) {
        System.out.println("save = " + input);
    }



}
