public class AList<T> {
    private T[] items;
    private int size;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = x;
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public T removeLast() {
        T last = getLast();
        items[size - 1] = null;
        size--;
        return last;
    }

    public void resize(int cap) {
        T[] resized = (T[]) new Object[cap];
        System.arraycopy(items, 0, resized, 0, size);
        items = resized;
    }

    public static void main(String[] args) {
    }
}
