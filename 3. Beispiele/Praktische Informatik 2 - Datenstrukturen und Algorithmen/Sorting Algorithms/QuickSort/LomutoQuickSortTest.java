package QuickSort;

import org.junit.Assert;
import org.junit.Test;

public class LomutoQuickSortTest {
    LomutoQuickSort<Integer> lomutoQuickSort = new LomutoQuickSort<Integer>();

    @Test
    public void testSwap(){
        Integer[] array = new Integer[100];
        for(int i=0;i<100;i++){
            array[i]=i;
        }
        for(int i=0;i<100;i=i+2){
            int first = array[i];
            int second = array[i+1];
            lomutoQuickSort.swap(array,i,i+1);
            Assert.assertEquals(second,(int) array[i]);
            Assert.assertEquals(first,(int) array[i+1]);
        }
    }

    @Test
    public void testQuickSort(){
        Integer[] array = {9,8,7,6,5,4,3,2,1,0};
        lomutoQuickSort.quickSort(array);
        for (int i=0;i<10;i++){
            Assert.assertEquals(i,(int)array[i]);
        }
    }
}
