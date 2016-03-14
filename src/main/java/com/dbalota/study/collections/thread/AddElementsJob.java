package com.dbalota.study.collections.thread;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public class AddElementsJob implements Callable<Long> {

    private CountDownLatch latch;
    private Collection<Integer> c;
    private int size;



    public AddElementsJob(CountDownLatch latch, Collection<Integer> c, int count) {
        this.latch = latch;
        this.c = c;
        this.size = count;
    }

    public Long call() throws Exception {
        latch.await();
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {

            synchronized (AddElementsJob.class) {
                if (c.size() < size) {
                    c.add(i);

                } else {
                    break;
                }
            }

        }
        return System.nanoTime() - startTime;
    }
}
