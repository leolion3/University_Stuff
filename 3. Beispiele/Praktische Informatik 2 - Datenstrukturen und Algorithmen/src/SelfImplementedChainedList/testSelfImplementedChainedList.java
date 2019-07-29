package SelfImplementedChainedList;

import org.junit.Assert;
import org.junit.Test;

/** This class tests the SelfImplementedChainedList class implementation */
public class testSelfImplementedChainedList {

    SelfImplementedChainedList<Integer> list = new SelfImplementedChainedList<Integer>();

    /** Test adding new elements to the list */
    @Test
    public void testAdd(){
        for(int i=0;i<1000;i++){
            list.add(i);
        }
        Assert.assertEquals(1000,list.size());
    }

    /** Test getting elements from the list */
    @Test
    public void testGet() {
        for (int i = 0; i <= 99; i++) {
            list.add(i);
        }

        Assert.assertTrue(list.get(0) == 0);
        Assert.assertTrue(list.get(50) == 50);
        Assert.assertTrue(list.get(99) == 99);
    }

    /** Tests getting the list's size */
    @Test
    public void testListSize(){
        for(int i=0;i<1000;i++){
            list.add(i);
        }
        Assert.assertEquals(1000,list.size());
    }
}
