package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    private class Comp1<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return (int) o1 - (int) o2;
        }
    }

    private class Comp2<T> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return (int) o2 - (int) o1;
        }
    }

    @Test
    public void constructorTest() {
        MaxArrayDeque<Integer> d = new MaxArrayDeque<>(new Comp1<>());
        for (int i = 0; i < 100; i++) {
            d.addFirst(i);
        }
        assertEquals(99, (int) d.max());
    }

    @Test
    public void maxWithComparator() {
        MaxArrayDeque<Integer> d = new MaxArrayDeque<>(new Comp1<>());
        for (int i = 0; i < 100; i++) {
            d.addFirst(i);
        }
        assertEquals(0, (int) d.max(new Comp2<>()));
        assertEquals(99, (int) d.max());
    }
}
