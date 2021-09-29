import java.util.Iterator;
import java.util.NoSuchElementException;

/** This class implements a simple double-linked-list
 * The Node class is used to store the list's elements */
public class DoubleLinkedList<T> {

    private Node<T> first,current;
    private int size=0;

    /** Add an element to the list
     * @param key - the element to add to the list */
    public void add(T key){
        if (first==null){
            first=new Node<>(null,null,key);
            current=first;
        }
        else{
            current.setNext(new Node<>(current,null,key));
            current=current.getNext();
        }
        size++;
    }

    /** Add an element at the beginning of the list
     * @param key - the element to add to the beginning of the list */
    public void addFirst(T key){
        first=new Node<>(null,first,key);
        size++;
    }

    /** @return the list's size */
    public int size(){
        return size;
    }

    /** Get the element stored at index i
     * @param index - the index of the requested element
     * @return the saved element at index i */
    public T get(int index){
        if (index<0||index>size||first==null){
            throw new NoSuchElementException();
        }
        else{
            Node<T> searchNode = first;
            for (int i=0;i<index;i++){
                searchNode=searchNode.getNext();
            }
            return searchNode.getKey();
        }
    }

    /** Check if an element exists in the list
     * @param key - the element to search for */
    public boolean contains(T key){
        Iterator iterator = this.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(key)){
                return true;
            }
        }
        return false;
    }

    /** Remove an element from the list
     * @param key - the element to remove */
    public void remove(T key){
        if (contains(key)){
            Node<T> searchNode = first;
            while (searchNode!=null){
                if(first.getKey().equals(key)){
                    first=first.getNext();
                    break;
                }
                else if (searchNode.getKey().equals(key)){
                    if (searchNode.getNext()!=null){
                        searchNode.getNext().setPrevious(searchNode.getPrevious());
                    }
                    if (searchNode.getPrevious()!=null){
                        searchNode.getPrevious().setNext(searchNode.getNext());
                    }
                    break;
                }
                searchNode=searchNode.getNext();
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
            private int currentLocation=0;

            @Override
            public boolean hasNext() {
                return currentLocation<size;
            }

            @Override
            public T next() {
                return get(currentLocation++);
            }
        };
    }

    /** Inner class Node
     * many Nodes make up the list */
    private class Node<T>{
        private Node<T> previous,next;
        private T key;

        private Node(Node<T> previous,Node<T> next,T key){
            this.previous=previous;
            this.next=next;
            this.key=key;
        }

        /** @return the Node's predecessor */
        private Node<T> getPrevious(){
            return previous;
        }

        /** Set the Node's predecessor
         * @param predecessor - the new predecessor */
        private void setPrevious(Node<T> predecessor){
            this.previous=predecessor;
        }

        /** @return the Node's successor */
        private Node<T> getNext(){
            return next;
        }

        /** Set the Node's successor
         * @param successor - the new successor */
        private void setNext(Node<T> successor){
            this.next=successor;
        }

        /** @return the key stored in the Node */
        private T getKey(){
            return key;
        }

        /** Set the Node's content
         * @param key - the key to store in the Node */
        private void setKey(T key){
            this.key=key;
        }
    }
}
