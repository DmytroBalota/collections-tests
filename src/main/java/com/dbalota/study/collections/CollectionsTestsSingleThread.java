package com.dbalota.study.collections;

import java.util.Collection;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public class CollectionsTestsSingleThread extends CollectionsTestsAbstract implements CollectionsTests {
    public long addTest(Collection<Integer> c, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            c.add(i);
        }
        return System.nanoTime() - startTime;
    }



}
