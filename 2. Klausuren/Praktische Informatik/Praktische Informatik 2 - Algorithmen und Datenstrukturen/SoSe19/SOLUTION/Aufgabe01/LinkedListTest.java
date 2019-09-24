package Aufgabe01;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class LinkedListTest {

    @Test
    public void testNoSuccessor(){
        Assert.assertNull(LinkedList.remove(null,null));
    }

    @Test
    public void testRemoveFirst(){
        Node<Integer> first = new Node<>(1,new Node<>(2,null));
        Assert.assertTrue(first.getNext().getValue().equals(2));
        Assert.assertTrue(LinkedList.remove(first,1).getValue().equals(2));
    }

    @Test
    public void testRemove(){
        Node<Integer> node = new Node<Integer>(0,new Node<Integer>(1,new Node<Integer>(2,new Node<Integer>(3,new Node<Integer>(4,null)))));
        LinkedList.remove(node,2);
        Assert.assertTrue(node.getNext().getNext().getValue().equals(3));
    }
}
