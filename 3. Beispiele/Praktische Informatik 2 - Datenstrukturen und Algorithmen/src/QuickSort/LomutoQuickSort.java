package QuickSort;

/** This Class implements the Lomuto partition scheme QuickSort algorithm */
@SuppressWarnings("all")
public class LomutoQuickSort<T extends Comparable<? super T>> {

    /** Constructor */
    LomutoQuickSort(){}

    /** LomutoQuickSort method */
    private void quickSort(T[] array,int bottom,int top){
        if(bottom<top){
            int pivot = partition(array,bottom,top);
            quickSort(array,bottom,pivot-1);
            quickSort(array,pivot+1,top);
        }
    }

    /** Partitions the array */
    private int partition(T[] array,int bottom,int top) {
        T pivot = array[top];
        int i=bottom;
        for(int j=bottom;j<top;j++){
            if(array[j].compareTo(pivot)<0){
                swap(array,i,j);
                i++;
            }
        }
        swap(array,i,top);
        return i;
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
