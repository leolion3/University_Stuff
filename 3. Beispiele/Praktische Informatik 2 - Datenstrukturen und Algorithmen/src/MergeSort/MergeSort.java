package MergeSort;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class MergeSort<T extends Comparable<? super T>> {

    T[] output;

    MergeSort(){}

    public void mergeSort(T[] array){
        mergeSort(array,array.clone(),0,array.length);
    }

    private void mergeSort(T[] array,T[] array2,int left,int right){
        if(left+1<right){
            int middle = (left+right)/2;
            mergeSort(array,array2,middle,right);
            mergeSort(array,array2,left,middle);
            merge(array,array2.clone(),left,middle,right);
        }
    }

    private void merge(T[] array,T[] array2,int left,int middle,int right){

    }
}
