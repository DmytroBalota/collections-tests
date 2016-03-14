package com.dbalota.study.collections;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by Dmytro_Balota on 3/14/2016.
 */
public class Main {

    public static final int COLLECTION_SIZE = 1000000;
    public static final int COLLECTION_SIZE_IN_MULTY_THREADS = 10000;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        CollectionsTests testSingleThread = new CollectionsTestsSingleThread();

        CollectionsTests testMultiThread = new CollectionsTestsMultiThreads();

        List<Collection> collections = new ArrayList<Collection>();

        collections.add(new ArrayList());
        collections.add(new LinkedList());
        collections.add(new HashSet());
        collections.add(new LinkedHashSet());
        collections.add(new TreeSet());
        collections.add(new ArrayDeque());
        collections.add(new PriorityQueue());
        collections.add(new ArrayBlockingQueue(COLLECTION_SIZE));

        System.out.println("=================SINGLE THREAD================");
        int index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, c.getClass().getName()));
        }
        //adding
        System.out.println(String.format("\nAdding %s elements: (milliseconds)", COLLECTION_SIZE));
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testSingleThread.addTest(c, COLLECTION_SIZE) / 1000000));
        }

        System.out.println("\nRemoving element: (nanoseconds)");
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testSingleThread.removeTest(c, COLLECTION_SIZE >> 1)));
        }


        System.out.println("\nContains element: (nanoseconds)");
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testSingleThread.containsTest(c, COLLECTION_SIZE - 1)));
        }

        System.out.println("\n============MULTI THREADS with synchronized collection==============");
        collections.clear();
        collections.add(Collections.synchronizedCollection(new ArrayList()));
        collections.add(Collections.synchronizedCollection(new LinkedList()));
        collections.add(Collections.synchronizedCollection(new HashSet()));
        collections.add(Collections.synchronizedCollection(new LinkedHashSet()));
        collections.add(Collections.synchronizedCollection(new TreeSet()));
        collections.add(Collections.synchronizedCollection(new ArrayDeque()));
        collections.add(Collections.synchronizedCollection(new PriorityQueue()));
        collections.add(Collections.synchronizedCollection(new ArrayBlockingQueue(COLLECTION_SIZE_IN_MULTY_THREADS)));
        //adding multithread

        index = 0;
        for (Collection c : collections) {
            Field field = c.getClass().getDeclaredField("c");
            field.setAccessible(true);
            System.out.print(String.format("\t %s) %s", index++, field.get(c).getClass().getName()));
        }
        System.out.println(String.format("\nAdding %s elements: (milliseconds)", COLLECTION_SIZE_IN_MULTY_THREADS));
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testMultiThread.addTest(c, COLLECTION_SIZE_IN_MULTY_THREADS) / 1000000));
        }

        System.out.println(String.format("\nIterating %s elements: (milliseconds)", COLLECTION_SIZE_IN_MULTY_THREADS));
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testMultiThread.iterateElements(c, COLLECTION_SIZE_IN_MULTY_THREADS) / 1000000));
        }


        System.out.println("\n============MULTI THREADS with concurrent collection==============");
        collections.clear();

        collections.add(new CopyOnWriteArrayList());
        collections.add(new CopyOnWriteArraySet());
        collections.add(new ConcurrentSkipListSet());
        collections.add(new ConcurrentLinkedDeque());


        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, c.getClass().getName()));
        }
        System.out.println(String.format("\nAdding %s elements: (milliseconds)", COLLECTION_SIZE_IN_MULTY_THREADS));
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testMultiThread.addTest(c, COLLECTION_SIZE_IN_MULTY_THREADS) / 1000000));
        }

        System.out.println(String.format("\nIterating %s elements: (milliseconds)", COLLECTION_SIZE_IN_MULTY_THREADS));
        index = 0;
        for (Collection c : collections) {
            System.out.print(String.format("\t %s) %s", index++, testMultiThread.iterateElements(c, COLLECTION_SIZE_IN_MULTY_THREADS) / 1000000));
        }
    }


}
