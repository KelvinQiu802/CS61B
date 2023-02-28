public class Maximizer {
    public static Comparable max(Comparable[] items) {
        int maxIndex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].compareTo(items[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return items[maxIndex];
    }
}
