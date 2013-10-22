package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;

import java.util.Iterator;

/**
 */
public class LinkedListSet<T> implements Iterable<T> {
    private LinkedList<T> list;

    public LinkedListSet() {
        list = new LinkedList<T>();
    }

    public void add(T obj) {
        if (!list.contains(obj)) {
            list.append(obj);
        }
    }

    public boolean contains(T obj) {
        return list.contains(obj);
    }

    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        boolean first = true;
        b.append("{");
        for (T obj : list) {
            if (!first) {
                b.append(", ");
            }
            if (obj != null) {
                b.append(obj.toString());
            } else {
                b.append("null");
            }
            first = false;
        }
        b.append("}");
        return b.toString();
    }

    public LinkedListSet<T> union(LinkedListSet<T> other) {
        if (other == null) {
            return this;
        }
        for (T t : other) {
            add(t);
        }
        return this;
    }

    public LinkedListSet<T> intersect(LinkedListSet<T> other) {
        if (other == null) {
            return new LinkedListSet<T>();
        }
        return null;
    }

    public int size() {
        return list.size();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof LinkedListSet)) {
            return false;
        }
        LinkedListSet otherSet = (LinkedListSet) other;
        LinkedListSet t = (LinkedListSet) this;
        for (Object o : this) {
            if (!otherSet.contains(o)) {
                return false;
            }
        }
        for (Object o : otherSet) {
            if (!(t.contains(o))) {
                return false;
            }
        }
        return true;
    }
}
