package QuickSort;

import java.util.NoSuchElementException;

public class QuickSort<T extends Comparable<? super T>> {

    /** Constructor*/
    QuickSort(){}

    /** This method implements the QuickSort Algorithm */
    private void quickSort(T[] array,int bottom,int top){
        int pivotIndex;
        try {
            pivotIndex = partition(array,bottom,top);
        } catch (NoSuchElementException e){
            return;
        }

        T pivot = array[pivotIndex];
        int lo = bottom;
        int hi = top;

        while(lo <= hi) {
            swap(array, lo, hi);
            while(array[lo].compareTo(pivot) < 0){
                lo++;
            }
            while(array[hi].compareTo(pivot) >= 0){
                hi--;
            }
        }

        quickSort(array, bottom, top-1);
        quickSort(array, lo, top);
    }

    /** This method creates the partitions used by the QuickSort algorithm */
    private int partition(T[] array,int bottom,int top){
        T aux = array[bottom];

        for( int i = bottom+1; i <= top; i++){
            if( aux.compareTo(array[i]) < 0) {
                return i;
            } else if ( aux.compareTo(array[i]) > 0) {
                return bottom;
            }
        }

        throw new NoSuchElementException();
    }

    /** Basic method to LomutoQuickSort an array */
    public void quickSort(T[] array){
        if(array==null||array.length==0){
            throw new NullPointerException();
        }
        quickSort(array,0,array.length-1);
    }

    /** Swaps element at pos i and pos j */
    public void swap(T[] array,int i,int j){
        T first = array[i];
        array[i] = array[j];
        array[j] = first;
    }
}
