package Aufgabe01;

/**
 * Excercise 1 : Deleting an Nodeent from a Linked List ( 20 pts )
 *
 * You are not allowed to use any Java Libraries
 */
public class LinkedList
{
    /**
     * This method deletes a Node element from a simple Linked-List.
     * If the element exists more than once, only the first one gets
     * removed. If it does not exist, the list stays unchanged!
     *
     * @param first The first element of the List. If the list is empty
     *              then it is null
     * @param key   The key stored in the element that will be removed,
     *              does not have the value null.
     * @return      The first element of the new list that does not
     *              contain the deleted element.
     */
    public static <T> Node<T> remove(final Node<T> first, final T key)
    {
        if (first==null){
            return null;
        }
        else if (first.getValue().equals(key)){
            return first.getNext();
        }
        else{
            Node<T> searchNode = first;
            while (searchNode.getNext()!=null){
                if (searchNode.getNext().getValue().equals(key)){
                    searchNode.setNext(searchNode.getNext().getNext());
                    break;
                }
                searchNode=searchNode.getNext();
            }
        }
        return first;
    }
}
