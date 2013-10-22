package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;

import java.util.*;

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
        LinkedListSet<T> newSet = new LinkedListSet<T>();
        for (T e : this) {
            newSet.add(e);
        }
        if (other == null) {
            return newSet;
        }
        for (T t : other) {
            newSet.add(t);
        }
        return newSet;
    }

    public LinkedListSet<T> intersect(LinkedListSet<T> other) {
        LinkedListSet<T> newSet = new LinkedListSet<T>();
        if (other == null) {
            return newSet;
        }
        for (T e : this) {
            if (other.contains(e)) {
                newSet.add(e);
            }
        }
        return newSet;
    }

    public int size() {
        return list.size();
    }

    @SuppressWarnings("unchecked")
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
        if (otherSet.size() != t.size()) {
            return false;
        }
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

    @Override
    public int hashCode() {
        int result = 73;
        List<Integer> codes = new ArrayList<Integer>();
        for (T e : this) {
            codes.add(e.hashCode());
        }
        Collections.sort(codes);
        for (Integer i : codes) {
            result = 41 * result + i;
        }
        return result;
    }
}
