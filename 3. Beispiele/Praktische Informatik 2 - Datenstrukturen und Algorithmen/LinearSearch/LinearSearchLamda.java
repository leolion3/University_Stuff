package LinearSearch;

import java.util.Comparator;
@SuppressWarnings("all")
public class LinearSearchLamda {

    /** This method implements a simple linear search algorithm
     * @param array - the array to search in
     * @param key - the key to search for
     * @return the index of the element if it has been found else @return -1
     * @throws NullPointerException if the array is null or the length is 0 */
    public static <T> int linearSearch(T[] array, T key, Comparator<T> c){
        if(array.length==0||array==null){
            throw new NullPointerException();
        }
        for (int i=0;i<array.length;i++){
            if(c.compare(array[i],key)==0){
                return i;
            }
        }
        return -1;
    }

}
