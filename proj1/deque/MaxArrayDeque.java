package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comp = c;
    }

    public T max() {
        int maxIndex = 0;
        for (int i = 1; i < size(); i++) {
            if (comp.compare(get(i), get(maxIndex)) > 0) {
                maxIndex = i;
            }
        }
        return get(maxIndex);
    }

    public T max(Comparator<T> c) {
        Comparator<T> temp = comp;
        comp = c;
        T value = max();
        comp = temp;
        return value;
    }
}
