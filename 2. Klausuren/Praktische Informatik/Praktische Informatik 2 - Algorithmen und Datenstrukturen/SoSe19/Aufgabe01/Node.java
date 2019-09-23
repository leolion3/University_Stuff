package Aufgabe01;

/** This is a simple Data class
 * no changes are permitted! */
@SuppressWarnings("all")
public class Node<T> {
    private T key;
    private Node<T> next;

    public Node(T key,Node<T> next){
        this.key = key;
        this.next = next;
    }

    /** @return the key stored in the node */
    public T getValue(){
        return key;
    }

    /** Change the Node's value
     * @param key - the value the Node will get */
    public void setValue(T key){
        this.key=key;
    }

    /** @return the Node's successor */
    public Node<T> getNext(){
        return next;
    }

    /** Set the Node's successor
     * @param next - the Node to become the successor */
    public void setNext(Node<T> next){
        this.next=next;
    }
}
