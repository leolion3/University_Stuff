package BinarySearch;

import java.util.NoSuchElementException;

public class BinarySearch<T extends Comparable<? super T>> {

    BinarySearch(){}

    /** This method implements a binary search algorithm
     * @param array - the array to search in
     * @param key - the element to search for in the array */
    public int fastBinarySearch(T[] array,T key) {
        if(array.length==0){
            return -1;
        }
        else{
            int bottom=0;
            int top = array.length;
            while (bottom+1!=top){
                int middle = (top+bottom) / 2;
                if(array[middle].compareTo(key)>0){
                    top=middle;
                }
                else{
                    bottom=middle;
                }
            }
            return array[bottom].compareTo(key)==0?bottom:-1;
        }
    }

    /** This algorithm implements another binary search algorithm provided by wikipedia
     * @param array - the array to search in
     * @param key - the element to search for in the array */
    public int binarySearch(T[] array,T key){
        int left=0;
        int right = array.length-1;
        while(left<=right){
            int middle = (left+right)/2;
            if(array[middle].compareTo(key)<0){
                left++;
            }
            else if(array[middle].compareTo(key)>0){
                right--;
            }
            else
                return middle;
        }
        throw new NoSuchElementException();
    }

}
