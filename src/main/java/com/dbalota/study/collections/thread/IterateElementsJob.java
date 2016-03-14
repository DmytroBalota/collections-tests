package com.dbalota.study.collections.thread;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public class IterateElementsJob implements Callable<Long> {

    private CountDownLatch latch;
    private Collection<Integer> c;
    private int size;



    public IterateElementsJob(CountDownLatch latch, Collection<Integer> c, int count) {
        this.latch = latch;
        this.c = c;
        this.size = count;
    }

    public Long call() throws Exception {
        latch.await();
        long startTime = System.nanoTime();
        for(Integer element : c){

        }
        return System.nanoTime() - startTime;
    }
}
