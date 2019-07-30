package InsertionSort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortTest {

    private InsertionSort<Integer> insertionSort = new InsertionSort<Integer>();

    @Test
    public void testInsertionSort(){
        int index=0;
        Integer[] array = new Integer[1000];
        for(int i=999;i>=0;i--){
            array[index] = i;
            index++;
        }
        insertionSort.insertionSort(array);
        for (int i=0;i<1000;i++){
            Assert.assertEquals(i,(int)array[i]);
        }
    }
}
