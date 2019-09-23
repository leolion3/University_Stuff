package Aufgabe02;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest{

    @Test
    public void testNoResult(){
        Integer[] array = {0,1,2,3,4,5,6,7,8,9};
        Assert.assertEquals(-1,BinarySearch.binarySearch(array,11));
    }

    @Test
    public void testBinarySearch(){
        Integer[] array = new Integer[100];
        for (Integer a=0;a<100;a++){
            array[a] = a;
        }
        for (Integer i : array){
            Assert.assertEquals(i,(Integer) BinarySearch.binarySearch(array,i));
        }
    }
}
