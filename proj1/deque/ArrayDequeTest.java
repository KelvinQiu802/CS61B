package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void createEmptyDeque() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        assertEquals(0, d.size());
        assertTrue(d.isEmpty());
    }

    @Test
    public void addItem() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addLast(100);
        d.addLast(200);
        assertEquals(2, d.size());
    }

    @Test
    public void removeItem() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.addLast(100);
        d.addLast(200);
        assertEquals(100, (int) d.removeFirst());
        assertEquals(d.size(), 1);
        d.addFirst(100);
        assertEquals(200, (int) d.removeLast());
        assertEquals(d.size(), 1);
    }

    @Test
    public void resizeTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            d.addFirst(5);
            d.addLast(6);
        }
        assertEquals(20, d.size());
        for (int i = 0; i < 10; i++) {
            d.removeFirst();
        }
        assertEquals(10, d.size());
        for (int i = 0; i < 5; i++) {
            d.removeLast();
        }
        assertEquals(5, d.size());
    }

    @Test
    public void getTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            d.addFirst(i);
            d.addLast(i);
        }
        assertEquals(9, (int) d.get(0));
        assertEquals(7, (int) d.get(2));
        assertEquals(0, (int) d.get(9));
    }

    @Test
    public void iteratorTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        Iterator<Integer> it = d.iterator();
        for (int i = 0; i < 10; i++) {
            d.addFirst(i);
            d.addLast(i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(it.next(), d.get(i));
        }
        assertFalse(it.hasNext());
    }

    @Test
    public void equalsTest() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        ArrayDeque<Integer> d2 = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            d.addFirst(i);
            d2.addFirst(i);
        }
        assertEquals(d, d2);
        d.removeLast();
        assertNotEquals(d, d2);
    }
}
