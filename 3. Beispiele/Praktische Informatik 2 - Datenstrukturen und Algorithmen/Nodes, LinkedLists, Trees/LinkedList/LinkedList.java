import java.util.Iterator;
import java.util.NoSuchElementException;

/** This class creates a simple LinkedList
 * Inner class Node is used to store the list's elements
 * Iterator can be used to iterate through the list
 * See down below */
public class LinkedList<T> {

    private int size = 0;
    private Node<T> first = null,current = null;

    /** @return the List's length */
    public int size(){
        return size;
    }

    /** Add an element at the beginning of the list
     * @param key - the key to add to the List's top */
    public void addFirst(T key){
        first = new Node<>(first,key);
        size++;
    }

    /** Add an element to the list
     * @param key - the key to add to the list */
    public void add(T key){
        if (first==null){
            first = new Node<>(null,key);
            current = first;
        }
        else{
            current.setNext(new Node<>(null,key));
            current = current.getNext();
        }
        size++;
    }

    /** Add an element at after a specific element
     * @param predecessor - the Node after which to add the new key
     * @param key - the key to add to the list */
    public void addAfter(Node<T> predecessor,T key){
        predecessor.setNext(new Node<>(predecessor.getNext(),key));
        size++;
    }

    /** Add an element before a specific element
     * @param successor - the Node before which to add the new element
     * @param key - the key to add to the list */
    public void addBefore(Node<T> successor,T key){
        successor.setNext(new Node<>(successor.getNext(),successor.getKey()));
        successor.setKey(key);
        size++;
    }

    /** Get an element from the list located at a specific index
     * @param index - the index of the element */
    public T get(int index){
        int starter = 0;
        if(index < size) {
            Node<T> searchNode = first;
            while (starter<size){
                if (starter==index){
                    return searchNode.getKey();
                }
                else if (searchNode.getNext()!=null){
                    searchNode = searchNode.getNext();
                    starter++;
                }
                else{
                    break;
                }
            }
        }
        throw new NoSuchElementException();
    }

    /** Checks if an element is contained in the list
     * @param key - the element to look for */
    public boolean contains(T key){
        Iterator iterator = this.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(key)){
                return true;
            }
        }
        return false;
    }

    /** Removed an element from the list
     * @param key - the element to remove */
    public void remove(T key){
        if (contains(key)){
            if (first.getKey().equals(key)){
                first = first.getNext();
            }
            else{
                Node<T> searchNode = first;
                while (searchNode.getNext()!=null){
                    if (searchNode.getNext().getKey().equals(key)){
                        searchNode.setNext(searchNode.getNext().getNext());
                        break;
                    }
                    searchNode=searchNode.getNext();
                }
            }
            size--;
        }
        else{
            throw new NoSuchElementException();
        }
    }

    /** Iterator */
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter<size;
            }

            @Override
            public T next() {
                return get(counter++);
            }
        };
    }

    /** Inner class Node
     * The Nodes will store the List's elements */
    private class Node<T>{
        private T key;
        private Node<T> next;

        /** Creates a simple Node containing a key
         * @param next - the Node's successor
         * @param key - the key saved in the Node */
        private Node(Node<T> next,T key){
            this.next = next;
            this.key = key;
        }

        /** @return the Node's successor */
        private Node<T> getNext(){
            return next;
        }

        /** Set the Node's successor
         * @param next - the new successor the Node will have */
        private void setNext(Node<T> next){
            this.next=next;
        }

        /** @return the key stored in the Node */
        private T getKey(){
            return key;
        }

        /** Set the Node's key
         * @param key - the new key to store in the Node */
        private void setKey(T key){
            this.key = key;
        }
    }
}
