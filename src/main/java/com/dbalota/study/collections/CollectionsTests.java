package com.dbalota.study.collections;

import java.util.Collection;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public interface CollectionsTests {
    long addTest(Collection<Integer> c, int count);
    long containsTest(Collection<?> c, Object o);
    long removeTest(Collection<?> c, Object o);
    long iterateElements(Collection<Integer> c, int count);
}
