package stack;

import java.util.Iterator;

/**
 * Stack Abstract Data Type
 *
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {
    private Node top = null;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T value) {
        Node oldTop = top;
        top = new Node();
        top.value = value;
        top.next = oldTop;
    }

    public T pop() {
        T value = top.value;
        top = top.next;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T currentValue = current.value;
            current = current.next;
            return currentValue;
        }
    }

    private class Node {
        T value;
        Node next;
    }
}
