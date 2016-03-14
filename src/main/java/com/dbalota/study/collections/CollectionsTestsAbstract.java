package com.dbalota.study.collections;

import java.util.Collection;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public abstract class CollectionsTestsAbstract implements CollectionsTests {
    public long addTest(Collection<Integer> c, int count) {
        return 0;
    }

    public long containsTest(Collection<?> c, Object o) {
        long startTime = System.nanoTime();
        c.contains(o);
        return System.nanoTime() - startTime;
    }

    public long removeTest(Collection<?> c, Object o) {
        long startTime = System.nanoTime();
        c.remove(o);
        return System.nanoTime() - startTime;
    }

    public long iterateElements(Collection<Integer> c, int count) {
        long startTime = System.nanoTime();
        for(Integer element : c){

        }
        return System.nanoTime() - startTime;
    }
}
