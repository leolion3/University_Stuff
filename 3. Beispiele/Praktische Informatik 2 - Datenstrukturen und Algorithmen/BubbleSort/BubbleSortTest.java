package BubbleSort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest {
    BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();

    @Test
    public void testBubbleSort(){
        Integer[] array = new Integer[1000];
        int index=0;
        for(int i=999;i>=0;i--){
            array[index]=i;
            index++;
        }
        bubbleSort.BubbleSort(array);
        for(int i=0;i<1000;i++){
            Assert.assertEquals(i,(int)array[i]);
        }
    }
}
