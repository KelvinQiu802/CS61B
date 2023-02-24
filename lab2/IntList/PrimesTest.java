package IntList;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimesTest {
    @Test
    public void changed() {
        IntList lst = IntList.of(2, 15, 16, 17, 18);
        assertEquals("2 -> 15 -> 16 -> 17 -> 18", lst.toString());

        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("4 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void unchanged() {
        IntList lst = IntList.of(14, 15, 16, 16, 18);
        assertEquals("14 -> 15 -> 16 -> 16 -> 18", lst.toString());

        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 16 -> 18", lst.toString());
        assertFalse(changed);
    }
}
