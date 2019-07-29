public class Node<T> {

    private T containedElement;
    private int id;

    public Node(int id,T key){
        this.containedElement=key;
        this.id=id;
    }

    public T getKey(){
        return containedElement;
    }
}
