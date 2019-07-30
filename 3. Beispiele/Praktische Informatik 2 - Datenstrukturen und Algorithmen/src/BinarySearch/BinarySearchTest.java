package BinarySearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class BinarySearchTest {

    BinarySearch<Integer> binarySearch = new BinarySearch<Integer>();

    @Test (expected = NoSuchElementException.class)
    public void testBinarySearch(){
        Integer[] array = new Integer[1000];
        for(int i=0;i<1000;i++){
            array[i]=i;
        }
        for(int i=0;i<1000;i++){
            Assert.assertEquals(i,binarySearch.binarySearch(array,i));
        }
        Assert.assertEquals(0,binarySearch.binarySearch(array,1001));
    }

    @Test
    public void testFastBinarySearch(){
        Integer[] array = new Integer[1000];
        for(int i=0;i<1000;i++){
            array[i]=i;
        }
        Assert.assertEquals(500,binarySearch.fastBinarySearch(array,500));
        for(int i=0;i<1000;i++){
            Assert.assertEquals(i,binarySearch.fastBinarySearch(array,i));
        }
        Assert.assertEquals(-1,binarySearch.fastBinarySearch(array,1001));
    }
}
