package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 */
public class LinkedList<T> implements Iterable<T> {

    private Node start;

    private class Node {
        private T object;
        private Node next;

        Node(T object, Node next) {
            this.object = object;
            this.next = next;
        }

        Node(T object) {
            this.object = object;
        }

        T getObject() {
            return object;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof LinkedList<?>.Node)) {
                return false;
            }
            Node node = (Node) obj;
            return node.object == object;
        }

        @Override
        public int hashCode() {
            int result = 37;
            result = 37 * result + (object != null
                    ? object.hashCode() : 0);
            return result;
        }
    }

    private class NodeIterator implements Iterator<T> {
        private Node current;

        public NodeIterator(Node start) {
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current != null) {
                T obj = current.getObject();
                current = current.getNext();
                return obj;
            }
            throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node getLastEntry() {
        if (start != null) {
            Node current = start;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return current;
        }
        return null;
    }

    public Iterator<T> iterator() {
        return new NodeIterator(start);
    }

    public T last() {
        Node e = getLastEntry();
        if (e != null) {
            return e.getObject();
        }
        return null;
    }

    public T first() {
        if (start != null) {
            return start.getObject();
        }
        return null;
    }

    public int size() {
        int i = 0;
        if (start != null) {
            Node current = start;
            while (current != null) {
                current = current.getNext();
                i += 1;
            }
        }
        return i;
    }

    public void prepend(T object) {
        start = new Node(object, start);
    }

    public void append(T object) {
        Node last = getLastEntry();
        if (last != null) {
            Node next = new Node(object);
            last.setNext(next);
        } else {
            start = new Node(object);
        }
    }

    public boolean contains(T object) {
        if (start != null) {
            Node current = start;
            while (current != null) {
                if (current.getObject() == object) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof LinkedList<?>)) {
            return false;
        }
        LinkedList<?> l = (LinkedList<?>) o;

        if (this.size() != l.size()) {
            return false;
        }

        LinkedList<?>.Node current = start;
        LinkedList<?>.Node otherCurrent = l.start;

        if (!current.equals(otherCurrent)) {
            return false;
        }

        while (current != null) {
            if (!current.equals(otherCurrent)) {
                return false;
            }
            current = current.getNext();
            otherCurrent = otherCurrent.getNext();
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = 97;
        for (T e : this) {
            result = 97 * result + e.hashCode();
        }
        return result;
    }
}
