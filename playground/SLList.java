public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    /* INVARIANT:  The first item (if it exists) is at sentinel.next */
    private final IntNode sentinel;
    private int size;
    private final int SENTINEL_VALUE = -1;

    /**
     * Create an empty SLList
     */
    public SLList() {
        sentinel = new IntNode(SENTINEL_VALUE, null);
        size = 1;
    }

    public SLList(int x) {
        sentinel = new IntNode(SENTINEL_VALUE, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public void addLast(int x) {
        addLast(sentinel, x);
        size++;
    }

    private void addLast(IntNode n, int x) {
        if (n.next == null) {
            n.next = new IntNode(x, null);
            return;
        }
        addLast(n.next, x);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLList l = new SLList();
        l.addLast(5);
        System.out.println(l.size());
    }
}