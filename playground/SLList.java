import javax.net.ssl.SSLContextSpi;

public class SLList<T> {
    private class Node {
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;

        }
    }

    /* INVARIANT:  The first item (if it exists) is at sentinel.next */
    private final Node sentinel;
    private int size;

    /**
     * Create an empty SLList
     */
    public SLList() {
        sentinel = new Node(null, null);
        size = 1;
    }

    public SLList(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size++;
    }

    public void addLast(T x) {
        addLast(sentinel, x);
        size++;
    }

    private void addLast(Node n, T x) {
        if (n.next == null) {
            n.next = new Node(x, null);
            return;
        }
        addLast(n.next, x);
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList<Integer> l = new SLList<>();
        l.addLast(5);
        l.addFirst(10);
        System.out.println(l.size());

        SLList<String> s = new SLList<>();
        s.addFirst("Hello");
        s.addLast("World");
        System.out.println(s.size());
    }
}