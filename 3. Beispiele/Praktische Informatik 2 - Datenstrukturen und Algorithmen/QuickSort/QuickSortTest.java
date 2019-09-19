package QuickSort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    QuickSort<Integer> quickSort = new QuickSort<Integer>();

    @Test
    public void testSwap(){
        Integer[] array = new Integer[100];
        for(int i=0;i<100;i++){
            array[i]=i;
        }
        for(int i=0;i<100;i=i+2){
            int first = array[i];
            int second = array[i+1];
            quickSort.swap(array,i,i+1);
            Assert.assertEquals(second,(int) array[i]);
            Assert.assertEquals(first,(int) array[i+1]);
        }
    }

    @Test
    public void testQuickSort(){
        Integer[] array = {1,0,4,3,2,5,6,8,7,9};
        quickSort.quickSort(array);
        for (int i=0;i<10;i++){
            System.out.println(array[i]);
        }
    }
}
