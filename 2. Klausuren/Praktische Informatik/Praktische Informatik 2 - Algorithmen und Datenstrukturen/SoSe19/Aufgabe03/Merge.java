package Aufgabe03;

/**
 * Exercise 3: Merging 2 Arrays into one sorted array ( 20 pts )
 *
 * No Java Libraries may be used. Comparable is the only exception!
 */
public class Merge
{
    /**
     * Implements combining 2 arrays in a new sorted array.
     * The amount of comparisons must not exceed array1.length + array.length.
     *
     * @param array1 The first sorted array. Neither it, nor its elements are null.
     *
     * @param array2 The second sorted array. Neither it, nor its elements are null.
     *
     * @return       A combination of array1 and array2, must also be sorted!
     */
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] merge(final T[] array1, final T[] array2)
    {
        return (T[]) new Comparable[0]; // remove this. May contain something useful for your solution...
    }
}
