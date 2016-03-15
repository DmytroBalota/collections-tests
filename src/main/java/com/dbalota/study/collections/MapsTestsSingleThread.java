package com.dbalota.study.collections;

import java.util.Map;

/**
 * Created by Dmytro_Balota on 3/15/2016.
 */
public class MapsTestsSingleThread implements MapsTests {
    public long addTest(Map<Integer, Integer> m, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            m.put(i, i);
        }
        return System.nanoTime() - startTime;
    }

    public long containsTest(Map<Integer, Integer> m, Object o) {
        long startTime = System.nanoTime();
        m.containsKey(o);
        return System.nanoTime() - startTime;
    }

    public long removeTest(Map<Integer, Integer> m, Object o) {
        long startTime = System.nanoTime();
        m.remove(o);
        return System.nanoTime() - startTime;
    }

    public long iterateElements(Map<Integer, Integer> m, int count) {
        long startTime = System.nanoTime();
        for (Map.Entry e : m.entrySet()) {

        }
        return System.nanoTime() - startTime;
    }
}
