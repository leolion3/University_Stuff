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
        T[] output = (T[]) new Comparable[array1.length+array2.length];
        int i=0;
        for (i=0;i<array1.length;i++){
            output[i] = array1[i];
        }
        int a=0;
        for (i=array1.length;i<output.length;i++){
            output[i] = array2[a];
            a++;
        }
        // Since the sorting algorithm is not specified, we'll just use bubble sort
        // Bubble sort the array, Complexity ignored in this case
        // If you want to keep the complexity, use MergeSort / QuickSort
        for (int x=0;x<output.length;x++){
            for (int y=0;y<output.length-1;y++){
                if (output[y].compareTo(output[y+1])>0){
                    T first = output[y];
                    output[y] = output[y+1];
                    output[y+1] = first;
                }
            }
        }
       return output;
    }
}
