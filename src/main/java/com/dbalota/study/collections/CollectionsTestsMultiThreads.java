package com.dbalota.study.collections;

import com.dbalota.study.collections.thread.AddElementsJob;
import com.dbalota.study.collections.thread.IterateElementsJob;

import java.util.Collection;
import java.util.concurrent.*;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public class CollectionsTestsMultiThreads extends CollectionsTestsAbstract implements CollectionsTests {


    public long addTest(Collection<Integer> c, int count) {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        Future<Long> f1 = ex.submit(new AddElementsJob(latch, c, count));
        Future<Long> f2 = ex.submit(new AddElementsJob(latch, c, count));

        latch.countDown();

        long time = 0;
        try {
            time += f1.get();
            time += f2.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
        return time;
    }

    public long iterateElements(Collection<Integer> c, int count) {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        Future<Long> f1 = ex.submit(new IterateElementsJob(latch, c, count));
        Future<Long> f2 = ex.submit(new IterateElementsJob(latch, c, count));

        latch.countDown();

        long time = 0;
        try {
            time += f1.get();
            time += f2.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
        return time;
    }

}
