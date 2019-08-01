package LinearSearch;

import org.junit.Assert;
import org.junit.Test;

public class LinearSearchLambdaTest {

    @Test
    public void testLinearSearch(){
        Integer[] array = new Integer[100];
        for (int i=0;i<100;i++){
            array[i] = i;
        }
        Assert.assertEquals(50,LinearSearchLamda.linearSearch(array,50,(i,j)->i-j));
    }
}
