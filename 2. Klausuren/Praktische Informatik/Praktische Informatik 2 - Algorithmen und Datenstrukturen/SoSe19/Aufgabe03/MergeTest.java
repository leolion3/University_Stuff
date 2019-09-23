package Aufgabe03;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class MergeTest {

    @Test
    public void MergeTest(){
        Integer[] array1 = {1,3,5,7,9};
        Integer[] array2 = {0,2,4,6,8};
        Comparable[] newArray;
        newArray = Merge.merge(array1,array2);
        for (Integer i=0;i<newArray.length;i++){
            Assert.assertTrue(newArray[i].equals(i));
        }
    }
}
