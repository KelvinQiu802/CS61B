package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements IDeque<T> {
    public static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        public Node(T item) {
            this.item = item;
            next = null;
            prev = null;
        }
    }

    private class DequeIterator implements Iterator<T> {
        private Node<T> curr;

        public DequeIterator() {
            curr = sentFront.next;
        }

        public boolean hasNext() {
            return curr.item != null;
        }

        public T next() {
            T nextValue = curr.item;
            curr = curr.next;
            return nextValue;
        }
    }

    private static final int SENTINEL = 66;
    private int size;
    private Node<T> sentFront;
    private Node<T> sentBack;

    public LinkedListDeque() {
        sentFront = new Node<>(null);
        sentBack = new Node<>(null);
        sentFront.next = sentBack;
        sentBack.prev = sentFront;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentFront = new Node<>(null);
        sentBack = new Node<>(null);
        Node<T> n = new Node<>(item);
        sentFront.next = n;
        n.prev = sentFront;
        n.next = sentBack;
        sentBack.prev = n;
        size = 1;
    }

    @Override
    public void addFirst(T item) {
        Node<T> n = new Node<>(item);
        Node<T> oldFirst = sentFront.next;
        sentFront.next = n;
        n.prev = sentFront;
        n.next = oldFirst;
        oldFirst.prev = n;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> n = new Node<>(item);
        Node<T> oldLast = sentBack.prev;
        sentBack.prev = n;
        n.next = sentBack;
        n.prev = oldLast;
        oldLast.next = n;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node<T> n = sentFront.next;
        while (n.item != null) {
            System.out.print(n.item + " ");
            n = n.next;
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;

        Node<T> first = sentFront.next;
        sentFront.next = first.next;
        first.next.prev = sentFront;
        size--;
        first.next = null;
        first.prev = null;
        return first.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;

        Node<T> last = sentBack.prev;
        sentBack.prev = last.prev;
        last.prev.next = sentBack;
        size--;
        last.prev = null;
        last.next = null;
        return last.item;
    }

    @Override
    public T get(int index) {
        if (index > size) return null;

        Node<T> n = sentFront.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.item;
    }

    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof LinkedListDeque) {
            if (this.size != ((LinkedListDeque<?>) obj).size) return false;
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(((LinkedListDeque<?>) obj).get(i))) return false;
            }
        }
        return true;
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentFront.next);
    }

    private T getRecursive(int index, Node<T> n) {
        if (index == 0) return n.item;
        if (n.item == null) return null;
        return getRecursive(index - 1, n.next);
    }
}
