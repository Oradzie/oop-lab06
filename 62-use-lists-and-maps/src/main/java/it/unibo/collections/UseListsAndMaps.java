package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int READING_ELEM = 1000;
    private static final int ADDING_ELEM = 100000;
    private static final int START = 1000;
    private static final int END = 2000;
    private static final long AFRICA_POPULATION = 1_110_635_000L;
    private static final long AMERICAS_POPULATION = 972_005_000L;
    private static final long ANTARCTICA_POPULATION = 0L;
    private static final long ASIA_POPULATION = 4_298_723_000L;
    private static final long EUROPE_POPULATION = 742_452_000L;
    private static final long OCEANIA_POPULATION = 38_304_000L;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> list = new ArrayList<Integer>();

        for (int i = START; i < END; i++) {
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> list2 = new LinkedList<>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int temp = list2.get(list2.size() - 1);
        list2.set(list2.size() - 1, list2.get(0));
        list2.set(0, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        System.out.print("| ");
        for (int element : list) {
            System.out.print(element + " | ");
        }
        System.out.println("");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i <= ADDING_ELEM; i++) {
            list.add(0, i);
        }

        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Adding "
                        + ADDING_ELEM + " elements into list in "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        time = System.nanoTime();
        for (int i = 0; i <= ADDING_ELEM; i++) {
            list2.add(0, i);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Adding "
                        + ADDING_ELEM + " elements into list2 in "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 0; i <= READING_ELEM; i++) {
            list.get(list.size() / 2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Reading "
                        + READING_ELEM + " elements into list in "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");

        time = System.nanoTime();
        for (int i = 0; i <= READING_ELEM; i++) {
            list2.get(list2.size() / 2);
        }

        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
                "Reading "
                        + READING_ELEM + " elements into list2 in "
                        + time
                        + "ns ("
                        + millis
                        + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Long> continents = new HashMap<String, Long>();

        continents.put("Africa", AFRICA_POPULATION);
        continents.put("Americas", AMERICAS_POPULATION);
        continents.put("Antartica", ANTARCTICA_POPULATION);
        continents.put("Asia", ASIA_POPULATION);
        continents.put("Europa", EUROPE_POPULATION);
        continents.put("Oceania", OCEANIA_POPULATION);
        /*
         * 8) Compute the population of the world
         */
        long result = 0;
        for (final long element : continents.values()) {
            result += element;
        }
        System.out.println("The world population is " + result);
    }
}
