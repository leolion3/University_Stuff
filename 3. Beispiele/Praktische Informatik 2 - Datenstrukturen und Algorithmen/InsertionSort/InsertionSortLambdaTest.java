package InsertionSort;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSortLambdaTest {

    @Test
    public void testInsertionSort(){
        Integer[] array = new Integer[100];
        int i=0;
        for(int j=99;j>=0;j--){
            array[i] = j;
            i++;
        }
        InsertionSortLambda.insertionSort(array,(a,j)->a-j);
        for (int j=0;j<array.length;j++){
            Assert.assertEquals(j,(int)array[j]);
        }
    }
}
