package MergeSort;

import java.util.Comparator;

public class MergeSortLambda<T> {

    /** This method sorts a given array using the Merge-Sort algorithm
     * @Calls void mergeSort(T[] array,T[] array2,int bottom,int top,Comparator<T> c)*/
    public static <T> void mergeSort(T[] array,Comparator<T> c){
        mergeSort(array,array.clone(),0,array.length,c);
    }

    /** This method implements the mergeSort algorithm
     * @param array - the array to be sorted
     * @param array2 - clone of array, used by algorithm
     * @param bottom - first index of the array
     * @param top - last index of the array */
    private static <T> void mergeSort(T[] array,T[] array2,int bottom,int top,Comparator<T> c){
        if(bottom+1<top){
            int middle = (bottom+top)/2;
            mergeSort(array,array2,bottom,middle,c);
            mergeSort(array,array2,middle,top,c);
            merge(array,array2,bottom,middle,top,c);
        }
    }

    /** This method merges the elements of an array
     * @param array - the array to be sorted
     * @param array2 - assisting array, used by algorithm
     * @param bottom - first index of the array
     * @param middle - middle index of the array
     * @param top - top index of the array */
    private static <T> void merge(T[] array, T[] array2, int bottom, int middle, int top, Comparator<T> c){
        int firstPointer = bottom; // First pointer starts at left end of array
        int secondPointer = middle; // Second pointer starts at middle of array
        int positionIn2Array = bottom; // Third pointer starts at first location in 2nd array
        while (firstPointer<middle || secondPointer<top){ // As long as !(firstPointer>=middle&&secondPointer>=top)
            // If the second pointer reached the end of the array, or the firstPointer is smaller than the middle of the
            // array and array[firstPointer] <= array[secondPointer]
            if(secondPointer==top||firstPointer<middle&&c.compare(array[firstPointer],array[secondPointer])<=0){
                // replace array2[positionIn2Array] with array[firstPointer]
                array2[positionIn2Array++] = array[firstPointer++];
            }
            else{
                // replace array2[positionIn2Array] with array[secondPointer]
                array2[positionIn2Array++] = array[secondPointer++];
            }
        }
        // Replace elements in first array with those in second array
        for(positionIn2Array=bottom;positionIn2Array<top;positionIn2Array++){
            array[positionIn2Array] = array2[positionIn2Array];
        }
    }
}
