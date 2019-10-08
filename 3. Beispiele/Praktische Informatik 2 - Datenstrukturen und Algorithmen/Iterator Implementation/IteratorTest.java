import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class IteratorTest {
    private IteratorExample<Integer> example = new IteratorExample<>();

    @Test
    public void testIterator(){
        for (int i=0; i<100 ;i++){
            example.list.add(i);
            Assert.assertEquals(i+1,example.list.size());
        }
        List<Integer> list = new ArrayList<>();
        /** How to use the implemented iterator and take all of
         * its element and store them in a new list */
        Iterator<Integer> iterator = example.iterator();
        /** Works for Java 8+, before:
         * while(iterator.hasNext()){
         *      list.add(iterator.next());
         * }*/
        iterator.forEachRemaining(list::add);
        for (int i=0;i<list.size();i++){
            Assert.assertEquals((Integer) i,list.get(i));
        }
        Assert.assertFalse(iterator.hasNext());
    }
}
