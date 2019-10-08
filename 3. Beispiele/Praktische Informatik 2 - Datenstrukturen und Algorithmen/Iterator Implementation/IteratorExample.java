import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** This class represents a basic way to implement an Iterator
 * We are going to be using the iterator on a simple ArrayList
 * To see how to use the new iterator, check the test class */
public class IteratorExample<T> {

    // Only public because of tests, don't you EVER do this
    // unless you have a good reason!
    public List<T> list = new ArrayList<>();

    /** Iterator implementation */
    public Iterator iterator(){
        return new Iterator() {
            // Counter for list
            private int counter=0;
            /** Check if there are elements left in the list */
            @Override
            public boolean hasNext() {
                return counter<list.size();
            }
            /** Get the list's next element */
            @Override
            public T next() {
                return list.get(counter++);
            }
        };
    }
}
