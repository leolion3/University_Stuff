package BinarySearch;

import java.util.Comparator;

@SuppressWarnings("all")
public class BinarySearchLamba {

    /** This method implements the binary search algorithm
     * @param array - the array to search in
     * @param key - the key to search for
     * @return the index of the key if it was found else @return -1 */
    public static <T> int binarySearch(T[] array, T key, Comparator<T> c){
        if(array.length==0||array==null){
            throw new NullPointerException();
        }
        int bottom = 0;
        int top = array.length-1;
        while (bottom+1<top){
            int middle = (top+bottom)/2;
            if(c.compare(array[middle],key)>0){
                top=middle;
            }
            else{
                bottom=middle;
            }
        }
        return c.compare(array[bottom],key)==0?bottom:-1;
    }
}
