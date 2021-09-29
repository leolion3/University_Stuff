package Aufgabe02;

import java.util.Comparator;

/**
 * Exercise 2: Implement a simple Binary Search Algorithm ( 20pts )
 *
 * Besides the Comparable the use of no other Java Libraries is permitted
 * Should you implement a linear search instead of a Binary one, you will
 * only get a fraction of the points!
 */
public class BinarySearch
{
    /**
     * Implements a binary search algorithm in an Array. The amount of comparisons
     * between Objects of the class T must not be greater than log_2(array.length) + 1
     *
     * @param array the Array in which to search. It will not be null and neither will
     *              its elements be!
     * @param key   The key to search for. Is not null.
     *
     * @return      -1, if the element cannot be found. Else return the index of the
     *              desired element.
     */
    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T key)
    {
        return -1;
    }
}
