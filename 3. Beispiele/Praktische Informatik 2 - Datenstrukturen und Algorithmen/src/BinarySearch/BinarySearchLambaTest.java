package BinarySearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchLambaTest {

    @Test
    public void testBinarySearch(){
        Integer[] array = new Integer[100];
        for (int i=0;i<100;i++){
            array[i] = i;
        }
        Assert.assertEquals(50,BinarySearchLamba.binarySearch(array,50,(i,j)->i-j));
    }
}
