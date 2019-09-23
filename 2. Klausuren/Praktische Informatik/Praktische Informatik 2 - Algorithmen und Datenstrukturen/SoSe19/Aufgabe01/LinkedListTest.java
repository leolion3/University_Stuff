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
}
