package DoubleChainedList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ExerciseListTest {

    @Test
    public void testAddRemoveContains() {
        List<String> l = new ExerciseList<>();
        l.add("lorem");
        l.add("ipsum");
        l.add("dolor");
        assertTrue(l.contains("lorem"));
        assertTrue(l.contains("ipsum"));
        assertTrue(l.contains("dolor"));
        l.remove("ipsum");
        assertFalse(l.contains("ipsum"));
        l.remove(1);
        assertFalse(l.contains("dolor"));
        assertTrue(l.contains("lorem"));
        l.remove(0);
        assertEquals(0, l.size());
        assertTrue(l.isEmpty());
    }

    @Test
    public void testGet() {
        ExerciseList<String> l = new ExerciseList<>();
        l.add("sit");
        l.add(0,"ipsum");
        l.add(1,"dolor");
        l.add(0,"lorem");
        assertEquals("lorem", l.get(0));
        assertEquals("ipsum", l.get(1));
        assertEquals("dolor", l.get(2));
        assertEquals("sit", l.get(3));

    }

    @Test
    public void testAddOneElement(){
        List<String> test = new ExerciseList<>();
        test.add("test");
        assertEquals(1,test.size());
    }
}
