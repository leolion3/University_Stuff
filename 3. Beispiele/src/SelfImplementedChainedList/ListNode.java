package SelfImplementedChainedList;

public class ListNode<T> {

    private T key;
    private int id;
    private ListNode<T> next;

    /** Creates a new Node with the desired ID and key */
    ListNode(int id,T key,ListNode<T> next){
        this.id=id;
        this.key=key;
        this.next=next;
    }

    /** @return the id of the node */
    public int getId() {
        return id;
    }

    /** @return the key stored in the node */
    public T getKey(){
        return key;
    }

    /** @return the node's successor */
    public ListNode<T> getNext() {
        return next;
    }

    /** set the node's successor */
    public void setNext(ListNode<T> next){
        this.next=next;
    }

}
