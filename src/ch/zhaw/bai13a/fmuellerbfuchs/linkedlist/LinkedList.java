package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 */
public class LinkedList<T> implements Iterable<T> {

    private Entry start;

    private class Entry {
        private T object;
        private Entry next;

        Entry(T object, Entry next) {
            this.object = object;
            this.next = next;
        }

        Entry(T object) {
            this.object = object;
        }

        T getObject() {
            return object;
        }

        Entry getNext() {
            return next;
        }

        void setNext(Entry next) {
            this.next = next;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof LinkedList<?>.Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return entry.next == next &&
                    entry.object == object;
        }
    }

    private class EntryIterator<T> implements Iterator<T> {
        private LinkedList<T>.Entry current;

        public EntryIterator(LinkedList<T>.Entry start) {
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

    private Entry getLastEntry() {
        if (start != null) {
            Entry current = start;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return current;
        }
        return null;
    }

    public Iterator<T> iterator() {
        return new EntryIterator<T>(start);
    }

    public T last() {
        Entry e = getLastEntry();
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
            Entry current = start;
            while (current != null) {
                current = current.getNext();
                i += 1;
            }
        }
        return i;
    }

    public void prepend(T object) {
        start = new Entry(object, start);
    }

    public void append(T object) {
        Entry last = getLastEntry();
        if (last != null) {
            Entry next = new Entry(object);
            last.setNext(next);
        } else {
            start = new Entry(object);
        }
    }

    public boolean contains(T object) {
        if (start != null) {
            Entry current = start;
            while (current != null) {
                if (current.getObject() == object) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof LinkedList<?>)) {
            return false;
        }
        LinkedList<?> l = (LinkedList<?>) o;

        LinkedList<?>.Entry current = start;
        LinkedList<?>.Entry oCurrent = l.start;

        if (current != oCurrent) {
            return false;
        }

        while (current != null) {
            if (!current.equals(oCurrent)) {
                return false;
            }
            current = current.getNext();
            oCurrent = oCurrent.getNext();
        }

        current = start;
        oCurrent = l.start;

        while (oCurrent != null) {
            if (!oCurrent.equals(current)) {
                return false;
            }
            current = current.getNext();
            oCurrent = oCurrent.getNext();
        }

        return true;
    }
}
