public class SelectionSort {
    public static void sort(String[] input) {
        // Find the smallest item
        // Move it to the front
        sort(input, 0);
    }

    /**
     * Sort input at position start.
     */
    private static void sort(String[] input, int start) {
        if (start == input.length) {
            return;
        }
        int smallest = getSmallest(input, start);
        swap(input, smallest, start);
        sort(input, start + 1);
    }

    /**
     * Swap item a with b.
     */
    public static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    /**
     * Return the smallest value index in the input array, starting at start.
     */
    public static int getSmallest(String[] input, int start) {
        int smallestIndex = start;
        for (int i = start; i < input.length; i++) {
            int order = input[i].compareTo(input[smallestIndex]);
            if (order < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
