package com.dbalota.study.collections;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Dmytro_Balota on 3/15/2016.
 */
public interface MapsTests {
    long addTest(Map<Integer,Integer> m, int count);
    long containsTest(Map<Integer,Integer> m, Object o);
    long removeTest(Map<Integer,Integer> m, Object o);
    long iterateElements(Map<Integer,Integer> m, int count);
}
