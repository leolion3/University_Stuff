package InsertionSort;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class InsertionSort<T extends Comparable<? super T>>{

    InsertionSort(){}

    private List<Integer> containedIndexes = new ArrayList<>();

    /** This method implements the insertion sort algorithm */
    public void insertionSort(T[] array) {
        List<T> elements = new ArrayList<>();
        for(int j=0;j<array.length;j++){
            T smallestElement = array[0];
            int smallestIndex = 0;
            if (contains(0)) {
                for (int i = 0; i < array.length; i++) {
                    if (!contains(i)) {
                        smallestElement = array[i];
                        smallestIndex=i;
                        break;
                    }
                }
            }
            for (int i = 0; i < array.length; i++) {
                if (!contains(i) && array[i].compareTo(smallestElement) < 0) {
                    smallestElement = array[i];
                    smallestIndex = i;
                }
            }
            containedIndexes.add(smallestIndex);
            elements.add(smallestElement);
        }
        for(int i=0;i<array.length;i++){
            array[i] = elements.get(i);
        }
    }

    /** Checks if the index is already within the new array */
    public boolean contains(int index){
        return containedIndexes.contains(index);
    }
}
