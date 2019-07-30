package DoubleChainedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/** Exercise 1 - DoubleChainedList
 * The below class implements a double-chained-list.
 * The list's elements are stored in the inner-class Node
 * Each Node has a next and a previous element which can be
 * accessed using getNext and getPrevious and set using
 * setPrevious and setNext.
 *
 * The listHead element's next pointer points at the list's first
 * element, and the previous points at the list's last element
 *
 * Implement the methods unlink and insertBefore that are used
 * by the methods remove and add
 *
 * The other methods MUST NOT BE CHANGED and any changes WILL NOT
 * BE RECOGNISED BY THE CORRECTION SYSTEM! */
@SuppressWarnings("all")
public class ExerciseList<E> implements List<E>{

    private Node<E> listHead;
    private int length;

    public ExerciseList(){
        this.listHead = new Node<>();
        this.listHead.setNext(this.listHead);
        this.listHead.setPrevious(this.listHead);
        this.length=0;
    }

    /** Removes an element from the list
     * The element's existence has already been checked
     * @param node - the node to be removed */
    private void unlink(Node<E> node){
        Node<E> pred = node.getPrevious();
        Node<E> succ = node.getNext();
        pred.setNext(succ);
        succ.setPrevious(pred);
        length--;
    }

    /** Add an Node node before the Node after
     * @param node - the node to be added
     * @param after - the node before which to insert the new Node */
    private void insertBefore(Node<E> node,Node<E> after){
        Node<E> pred = after.getPrevious();
        if(pred!=null) {
            pred.setNext(node);
        }
        node.setNext(after);
        node.setPrevious(pred);
        after.setPrevious(node);
        length++;
    }

    @Override
    public boolean add(E e){
        if(e == null){
            throw new NullPointerException();
        }
        Node<E> newNode = new Node<>(e);
        insertBefore(this.listHead,newNode);
        return true;
    }

    /** Check if the position index exists within the list else
     * @throws IndexOutOfBoundsException */
    private void checkPositionIndex(int index){
        if(index<0||length<index){
            throw new IndexOutOfBoundsException();
        }
    }
    /** Check if the Node's index exists within the list else
     * @throws IndexOutOfBoundsException */
    private void checkNodeIndex(int index){
        if(index<0||index>length){
            throw new IndexOutOfBoundsException();
        }
    }

    /** @return the Node at a specific index */
    private Node<E> getNode(int index){
        checkPositionIndex(index);
        Node<E> node;
        if((length>>1)>index){
            node=this.listHead.getNext();
            for(int i=0;i<index;i++){
                node=node.getNext();
            }
        }
        else{
            node=this.listHead;
            for(int i=0;i>index;i--){
                node=node.getPrevious();
            }
        }
        return node;
    }

    /**
     * Class creates Nodes used by the List above
     */
    private class Node<E> {
        private E data;
        private Node<E> previous, next;

        /** Creates an empty Node */
         public Node(){
            this.data=null;
            this.next=null;
            this.previous=null;
        }

        /** Creates Node only containing the element e */
         public Node(E e){
            this.data=e;
            this.next=null;
            this.previous=null;
        }

        /** Creates a Node with a predecessor and successor */
         public Node(E e,Node<E> previous,Node<E> next){
            this.data=e;
            this.previous=previous;
            this.next=next;
        }

        /** @return the data contained in the Node */
        public E getData(){
            return data;
        }

        /** Set the Node's data */
        public void setData(E data){
            this.data=data;
        }

        /** @return the Node's predecessor */
        public Node<E> getPrevious(){
            return previous;
        }

        /** Set the Node's predecessor */
        public void setPrevious(Node<E> previous){
            this.previous=previous;
        }

        /** @return the Node's successor */
        public Node<E> getNext(){
            return next;
        }

        /** Set the Node's successor */
        public void setNext(Node<E> next){
            this.next=next;
        }
    }

    /** @return the size of the List */
    @Override
    public int size(){
        return this.length;
    }

    /** Check if the List is empty */
    @Override
    public boolean isEmpty(){
        return this.size()==0;
    }

    /** Check if the List contains a specific element */
    @Override
    public boolean contains(Object o){
        if(o==null){
            throw new NullPointerException();
        }
        for(Node<E> n = this.listHead.getNext();n!=this.listHead;n = n.getNext()){
            if(o.equals(n.getData())){
                unlink(n);
                return true;
            }
        }
        return false;
    }

    /** Remove an object from the list */
    @Override
    public boolean remove(Object o){
        if(o==null){
            throw new NullPointerException();
        }
        for (Node<E> n=this.listHead.getNext();n!=this.listHead;n=n.getNext()){
            if(o.equals(n.getData())){
                unlink(n);
                return true;
            }
        }
        return false;
    }

    /** Clear the List */
    @Override
    public void clear(){
        this.length=0;
        this.listHead.setPrevious(this.listHead);
        this.listHead.setNext(this.listHead);
    }

    /** Get the data of a node at a specific index */
    @Override
    public E get(int index){
        checkNodeIndex(index);
        return getNode(index).getData();
    }

    /** Set the data of a specific node
     * @param index - the index of the node which's element to set
     * @param element - the element to be added at a specific index */
    @Override
    public E set(int index,E element){
        checkNodeIndex(index);
        if (element==null){
            throw new NullPointerException();
        }
        Node<E> n = getNode(index);
        E oldData = n.getData();
        n.setData(element);
        return oldData;
    }

    /** Add an element to the list
     * @param index - the location at which to add the element
     * @param element - the element to be added to the list */
    @Override
    public void add(int index,E element){
        checkNodeIndex(index);
        if (element==null){
            throw new NullPointerException();
        }
        Node<E> n = getNode(index);
        Node<E> newNode = new Node<>(element);
        insertBefore(n,newNode);
    }

    /** Remove the node at a specific index
     * @param index - the index at which to remove the node */
    @Override
    public E remove(int index){
        checkNodeIndex(index);
        Node<E> n = getNode(index);
        unlink(n);
        return n.getData();
    }

    /** Get the index of an object */
    @Override
    public int indexOf(Object o){
        if(o==null){
            throw new NullPointerException();
        }
        int index = -1;
        Node<E> n = listHead.getNext();
        for (int i=0;i<length;i++){
            if (o.equals(n.getData())){
                return i;
            }
            n=n.getNext();
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o){
        if(o==null){
            throw new NullPointerException();
        }
        Node<E> n = listHead.getPrevious();
        for(int i=length-1;i>=0;i--){
            if (o.equals(n.getData())){
                return i;
            }
            n=n.getPrevious();
        }
        return -1;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

