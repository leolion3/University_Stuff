package InsertionSort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("all")
public class InsertionSortLambda {

    /** This method implements the insertion sort algorithm
     * @param array - the array to be sorted */
    public static <T> void insertionSort(T[] array, Comparator<T> c){
        List<T> secondArray = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            T smallestElement = array[array.length-1];
            if(secondArray.contains(smallestElement)){
                for (int j=0;j<array.length-1;j++){
                    if(!secondArray.contains(array[j])){
                        smallestElement=array[j];
                        break;
                    }
                }
            }
            for(int j=0;j<array.length-1;j++){
                if(c.compare(array[j],smallestElement)<0&&!secondArray.contains(array[j])){
                    smallestElement=array[j];
                }
            }
            secondArray.add(smallestElement);
        }
        for(int i=0;i<secondArray.size();i++){
            array[i] = secondArray.get(i);
        }
    }
}
