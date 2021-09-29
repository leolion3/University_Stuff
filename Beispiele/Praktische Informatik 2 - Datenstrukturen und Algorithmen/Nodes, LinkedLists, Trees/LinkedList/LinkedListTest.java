import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListTest {

    @Test (expected = NoSuchElementException.class)
    public void testAddSizeGet(){
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertEquals(0,list.size());
        for (int i=0;i<100;i++){
            Assert.assertEquals(i,list.size());
            list.add(i);
        }
        Assert.assertEquals(0,(int)list.get(0));
        list.addFirst(5);
        Assert.assertEquals(5,(int)list.get(0));
        Assert.assertEquals(0,(int)list.get(1));
        list.get(200);
    }

    @Test
    public void testContains(){
        LinkedList<Integer> list = new LinkedList<>();
        Assert.assertFalse(list.contains(10));
        for (int i=0;i<100;i++){
            list.add(i);
            Assert.assertTrue(list.contains(i));
        }
        Assert.assertTrue(list.contains(50));
    }

    @Test (expected = NoSuchElementException.class)
    public void testRemove(){
        LinkedList<Integer> list = new LinkedList<>();
        list.remove(10);
        for (int i=0;i<100;i++){
            list.add(i);
            Assert.assertTrue(list.contains(i));
            Assert.assertEquals(i+1,list.size());
        }
        list.remove(0);
        Assert.assertEquals(1,(int)list.get(0));
        Assert.assertEquals(99,list.size());
        list.remove(99);
        Assert.assertEquals(98,list.size());
        list.get(99);
    }

    @Test
    public void testIterator(){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<100;i++){
            list.add(i);
            Assert.assertEquals(i+1,list.size());
        }
        int a=0;
        Iterator iterator =list.iterator();
        while (iterator.hasNext()){
            Assert.assertEquals(a,iterator.next());
            a++;;
        }
    }
}
