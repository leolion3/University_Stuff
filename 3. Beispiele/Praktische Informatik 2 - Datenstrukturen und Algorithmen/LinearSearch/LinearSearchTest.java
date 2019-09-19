package LinearSearch;

import org.junit.Assert;
import org.junit.Test;

public class LinearSearchTest {

    private LinearSearch<Integer> search = new LinearSearch<Integer>();

    @Test
    public void testLinearSearch(){
        Integer[] array = new Integer[1000];
        for(int i=0;i<1000;i++){
            array[i] = i;
        }
        Assert.assertEquals(500,search.linearSearch(array,500));
    }
}
