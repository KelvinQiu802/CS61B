package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> l1 = new AListNoResizing<>();
        BuggyAList<Integer> l2 = new BuggyAList<>();

        for (int i = 0; i < 3; i++) {
            l1.addLast(i);
            l2.addLast(i);
        }

        for (int i = 0; i < 3; i++) {
            assertEquals(l1.removeLast(), l2.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> L2 = new BuggyAList<>();

        int N = 1000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                L2.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int size2 = L2.size();
                assertEquals(size, size2);
            } else if (operationNumber == 2 && L2.size() > 0) {
                int last = L.getLast();
                int last2 = L2.getLast();
                assertEquals(last, last2);
            } else if (operationNumber == 3 && L2.size() > 0) {
                int last = L.removeLast();
                int last2 = L2.removeLast();
                assertEquals(last, last2);
            }
        }
    }
}
