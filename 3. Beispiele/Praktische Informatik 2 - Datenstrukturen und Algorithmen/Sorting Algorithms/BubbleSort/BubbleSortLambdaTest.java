package BubbleSort;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortLambdaTest {

    @Test
    public void testBubbleSort(){
        Integer[] array = new Integer[100];
        int i=0;
        for (int j=99;j>=0;j--){
            array[i] = j;
            Assert.assertEquals(j,(int)array[i]);
            i++;
        }
        BubbleSortLambda.bubbleSort(array,(a,j)->a-j);
        for (int j=0;j<array.length;j++){
            Assert.assertEquals(j,(int)array[j]);
        }
    }
}
