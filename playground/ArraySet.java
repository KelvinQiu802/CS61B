import org.w3c.dom.css.CSSImportRule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ArraySet<T> implements Iterable<T> {
    private class ArraySetIterator implements Iterator<T> {
        private int pos;

        public ArraySetIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T item = items[pos];
            pos++;
            return item;
        }
    }

    private final T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public static <G> ArraySet<G> of(G... staff) {
        ArraySet<G> set = new ArraySet<>();
        for (G x : staff) {
            set.add(x);
        }
        return set;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            // use obj.equals instead of ==
            if (x.equals(items[i])) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) throw new IllegalArgumentException("Can not add null to an ArraySet");
        if (contains(x)) return;
        items[size] = x;
        size++;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public String toString() {
        List<String> strList = new ArrayList<>();
        for (T x : this) {
            strList.add(x.toString());
        }
        return "(" + String.join(", ", strList) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof ArraySet other) {
            if (this.size != other.size) return false;
            for (T x : this) {
                if (!other.contains(x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add("Apple");
        s.add("Banana");
        s.add("Apple");  // ignored
        s.add("Kelvin");
        System.out.println(s.size());
        System.out.println(s.contains("Banana"));
        System.out.println(s);

        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String str : s
        ) {
            System.out.println(str);
        }

        ArraySet<Integer> intSet = ArraySet.of(1, 2, 3, 4);
        System.out.println(intSet);
    }
}
