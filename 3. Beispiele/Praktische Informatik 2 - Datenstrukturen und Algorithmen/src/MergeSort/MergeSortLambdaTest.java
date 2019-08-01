package MergeSort;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortLambdaTest {

    @Test
    public void testMergeSort(){
        Integer[] array = new Integer[100];
        int i=0;
        for (int j=99;j>=0;j--){
            array[i]=j;
            i++;
        }
        MergeSortLambda.mergeSort(array,(a,j) -> a-j);
        for(int j=0;j<100;j++){
            Assert.assertEquals(j,(int) array[j]);
        }
    }
}
