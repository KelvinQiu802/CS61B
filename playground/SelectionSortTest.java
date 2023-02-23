import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {
    /**
     * Test the SelectionSort sort method.
     */
    @Test
    public void testSort() {
        String[] input = {"ba", "az", "dr", "ce"};
        String[] expected = {"az", "ba", "ce", "dr"};

        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    /**
     * Test the SelectionSort getSmallest method.
     */
    @Test
    public void testGetSmallest() {
        String[] input = {"ba", "az", "dr", "ce"};
        int expected = 1;

        int actual = SelectionSort.getSmallest(input, 0);

        assertEquals(expected, actual);

        String[] input2 = {"az", "ba", "dr", "ce"};
        int expected2 = 1;

        int actual2 = SelectionSort.getSmallest(input, 1);

        assertEquals(expected2, actual2);
    }

    /**
     * Test the swap method.
     */
    @Test
    public void testSwap() {
        String[] input = {"ba", "az", "dr", "ce"};
        int a = 1;
        int b = 3;
        String[] expected = {"ba", "ce", "dr", "az"};

        SelectionSort.swap(input, a, b);

        assertArrayEquals(expected, input);
    }
}
