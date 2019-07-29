package SelfImplementedChainedList;

import java.util.NoSuchElementException;

public class SelfImplementedChainedList<T> {

    private int length = 0;
    private ListNode<T> first,current;

    SelfImplementedChainedList(){}

    /** This method adds elements to the list
     * @param key - the element to be added */
    public void add(T key){
        if(length==0){
            current = new ListNode<T>(0,key,current);
            first=current;
        }
        else{
            current.setNext(new ListNode<T>(length,key,current));
            current = current.getNext();
        }
        length++;
    }

    /** This method gets the key of a desired element
     * @param id - the id of the Node which's key to return */
    public T get(int id){
        ListNode<T> search = first;
        int counter=0;
        while(counter<length){
            if(search.getId()==id){
                return search.getKey();
            }
            search = search.getNext();
            counter++;
        }
        throw new NoSuchElementException();
    }

    /** This method returns the size of the list */
    public int size(){
        return length;
    }
}
