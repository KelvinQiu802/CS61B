public class IntList {
    public int first;
    public IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    @Override
    public String toString() {
        if (rest == null) {
            return first + " -> null";
        }
        return first + " -> " + this.rest.toString();
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return this.rest.get(i - 1);
    }

    /**
     * Return an IntList identical to L, but with all values incremented by x.
     */
    public static IntList incrList(IntList l, int x) {
        if (l.rest == null) {
            return new IntList(l.first + x, null);
        }
        return new IntList(l.first + x, incrList(l.rest, x));
    }

    /**
     * All values incremented by x.
     * Can not use new keyword.
     */
    public static void dincrList(IntList l, int x) {
        l.first += x;
        if (l.rest != null) {
            dincrList(l.rest, x);
        }
    }

    public static void main(String[] args) {
        IntList a = new IntList(5, null);
        a = new IntList(10, a);
        a = new IntList(15, a);

        System.out.println(a);

        System.out.println("Size: " + a.size());

        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));

        IntList b = IntList.incrList(a, 10);
        System.out.println(b);

        IntList.dincrList(a, 10);
        System.out.println(a);
    }
}
