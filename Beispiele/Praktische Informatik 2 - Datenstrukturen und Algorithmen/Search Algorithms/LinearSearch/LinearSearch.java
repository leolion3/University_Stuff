package LinearSearch;

public class LinearSearch<T extends Comparable<? super T>> {

    LinearSearch(){}

    /** This method implements a linear search algorithm using a for-loop
     * @param array - the array to search in
     * @param key - the element to search for */
    public int linearSearch(T[] array,T key){
        for(int i=0;i<array.length;i++){
            if(array[i].compareTo(key)==0){
                return i;
            }
        }
        return -1;
    }
}
