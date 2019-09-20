package BubbleSort;

import java.util.Comparator;

public class BubbleSortLambda {

    /** This method implements a bubble sort algorithm
     * @param array - the array to be sorted */
    public static <T> void bubbleSort(T[] array, Comparator<T> c){
        for (int i=0;i<array.length;i++){
            for (int j=0;j<array.length-1;j++){
                if(c.compare(array[j+1],array[j])<0){
                    swap(array,j,j+1);
                }
            }
        }
    }

    /** This method swaps 2 elements in the array
     * @param array - the array to swap the elements in
     * @param first - the first element
     * @param second - the second element else @return -1else @return -1*/
    private static <T> void swap(T[] array,int first,int second){
        T firstElement = array[first];
        array[first] = array[second];
        array[second] = firstElement;
    }

}
