package BubbleSort;

public class BubbleSort<T extends Comparable<? super T>> {

    /** Constructor */
    BubbleSort(){}

    /** This method implements the BubbleSort Algorithm*/
    public void BubbleSort(T[] array){
        for(int j=0;j<array.length;j++) {
            for (int i = 0; i < array.length-1; i++) {
                if(array[i].compareTo(array[i+1])>0){
                    swap(array,i,i+1);
                }
            }
        }
    }

    /** Swaps 2 elements' locations in an array */
    private void swap(T[] array,int first,int second){
        T firstElement = array[first];
        array[first] = array[second];
        array[second] = firstElement;
    }
}
