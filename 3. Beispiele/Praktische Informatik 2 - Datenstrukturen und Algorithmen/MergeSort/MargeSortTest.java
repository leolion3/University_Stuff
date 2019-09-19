package MergeSort;

import org.junit.Assert;
import org.junit.Test;
@SuppressWarnings("all")
public class MargeSortTest {

    MergeSort<Integer> mergeSort = new MergeSort<Integer>();

    @Test
    public void testMergeSort(){
        Integer[] array = new Integer[1000];
        int i=0;
        for (int a=999;a>=0;a--){
            array[i] = a;
            i++;
        }
        mergeSort.mergeSort(array);
        for (int a=0;a<1000;a++){
            Assert.assertEquals(a,(int) array[a]);
        }
    }

}
