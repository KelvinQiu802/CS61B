package deque;


import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private class DequeIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T value = get(index);
            index++;
            return value;
        }
    }

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
    }

    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private void resize(int newSize) {
        assert size <= newSize;
        T[] newArr = (T[]) new Object[newSize];
        int newNextFirst = newSize / 2;
        for (int i = 1; i <= size; i++) {
            int newIndex = newNextFirst + i;
            newIndex = newIndex < newSize ? newIndex : newIndex - newSize;
            int index = nextFirst + i;
            index = index < items.length ? index : index - items.length;
            newArr[newIndex] = items[index];
        }
        nextFirst = newNextFirst;
        nextLast = nextFirst + size + 1;
        nextLast = nextLast < newSize ? nextLast : nextLast - newSize;
        items = newArr;
    }

    @Override
    public void addFirst(T item) {
        if (nextFirst == nextLast) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = nextFirst == 0 ? items.length - 1 : nextFirst - 1;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (nextFirst == nextLast) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        nextLast = nextLast + 1 == items.length ? 0 : nextLast + 1;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 1; i <= size; i++) {
            int index = nextFirst + i;
            index = index < items.length ? index : index - items.length;
            sb.append(items[index]);
            sb.append(", ");
        }
        sb.append("}");
        System.out.println(sb);
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size >= 16 && (size / (double) items.length <= 0.25)) {
            resize(size + 1);
        }
        nextFirst = nextFirst == items.length - 1 ? 0 : nextFirst + 1;
        T oldFirst = items[nextFirst];
        size--;
        return oldFirst;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (size >= 16 && (size / (double) items.length <= 0.25)) {
            resize(size + 1);
        }
        nextLast = nextLast == 0 ? items.length - 1 : nextLast - 1;
        T oldLast = items[nextLast];
        size--;
        return oldLast;
    }

    @Override
    public T get(int index) {
        int i = nextFirst + 1 + index;
        i = i >= items.length ? i - items.length : i;
        return items[i];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Deque) {
            if (this.size != ((Deque<?>) obj).size()) {
                return false;
            }
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(((Deque<?>) obj).get(i))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
