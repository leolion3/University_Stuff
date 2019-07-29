package SelfImplementedArray;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTest {

    private Array<Integer> testArray = new Array<>(1000);

    /** @Test the set and get methods */
    @Test
    public void testSetGet(){

        // Test set ( if set fails, it will throw an exception )
        for(int i=0;i<1000;i++){
            testArray.set(i,i); // Set element at index i to i
        }

        // Test get
        for(int i=0;i<1000;i++){
            Assert.assertEquals(i,(int) testArray.get(i)); // Element at index i is also i
        }
    }

    /** @Test length method */
    @Test
    public void testLength(){
        Assert.assertEquals(1000,testArray.length());
    }

    /** @Test insert method */
    @Test
    public void testInsert(){
        Array<Integer> test = new Array<>(1000); // array elements are 0 - 999
        test.insert(1234); // new array length = 1001, elements range from 0 - 1000
        Assert.assertEquals(1234,(int) test.get(1000)); // 1000 is the index and not the length
    }

    /** @Test remove method */
    @Test
    public void testRemove(){
        Array<Integer> test = new Array<>(1000);
        for(int i=0;i<1000;i++){
            test.set(i,i);
        }
        test.remove(500); // element at index 500 is 500
        Assert.assertEquals(501,(int) test.get(500)); // element 500 got removed, and was replaced with 501
        Assert.assertEquals(999,test.length());
    }

    /** @Test empty method */
    @Test
    public void testEmpty(){
        Array<Integer> test = new Array<>(0);
        Assert.assertEquals(true,test.empty());
    }

}
