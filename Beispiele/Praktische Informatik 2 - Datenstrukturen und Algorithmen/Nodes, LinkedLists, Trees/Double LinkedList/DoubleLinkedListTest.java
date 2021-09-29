import org.junit.Assert;
import org.junit.Test;

public class DoubleLinkedListTest {

    @Test
    public void testDoubleLinkedList(){
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        Assert.assertEquals(0,list.size());
        for (int i=0;i<100;i++){
            list.add(i);
            Assert.assertEquals(i+1,list.size());
            Assert.assertEquals(i,(int)list.get(i));
        }
        Assert.assertEquals(100,list.size());
        list.addFirst(5);
        Assert.assertEquals(5,(int)list.get(0));
        Assert.assertEquals(0,(int)list.get(1));
        list.remove(5);
        Assert.assertEquals(0,(int)list.get(0));
        Assert.assertEquals(100,list.size());
        list.remove(99);
        Assert.assertEquals(99,list.size());
    }
}
