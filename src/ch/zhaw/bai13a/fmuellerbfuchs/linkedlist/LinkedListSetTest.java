package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;

import org.junit.Test;

/**
 */
public class LinkedListSetTest {
    @Test
    public void testUnique() {
        LinkedListSet<Integer> i = new LinkedListSet<Integer>();
        i.add(1);
        i.add(1);
        i.add(2);
        i.add(2);
        i.add(2);
        assert i.size() == 2 : "i.size() is " + i.size();
    }

    @Test
    public void testEquals() {
        LinkedListSet<Integer> i = new LinkedListSet<Integer>();
        LinkedListSet<Integer> i1 = new LinkedListSet<Integer>();
        i.add(1);
        i.add(2);
        i1.add(2);
        i1.add(1);
        assert i.equals(i1): "!i.equals(i1)" + i + " " + i1;
        assert i1.equals(i);
        assert i.hashCode() == i1.hashCode();
        i1.add(3);
        assert !i.equals(i1): "i.equals(i1)" + i + " " + i1;
        assert i.hashCode() != i1.hashCode();
        LinkedListSet<Integer> i2 = new LinkedListSet<Integer>();
        LinkedListSet<Integer> i3 = new LinkedListSet<Integer>();
    }

    @Test
    public void testToString() {
        LinkedListSet<Integer> i = new LinkedListSet<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        assert i.toString().equals("{1, 2, 3}");
    }

    @Test
    public void testSize() {
        LinkedListSet<Integer> set = new LinkedListSet<Integer>();
        for (int i = 0; i < 1000; i++) {
            set.add(i);
        }
        assert set.size() == 1000;
        LinkedListSet<Integer> set2 = new LinkedListSet<Integer>();
        for (int i = 0; i < 1000; i++) {
            set2.add(1);
        }
        assert set2.size() == 1;
    }

    @Test
    public void testUnion() {
        LinkedListSet<Integer> set = new LinkedListSet<Integer>();
        LinkedListSet<Integer> set2 = new LinkedListSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(1);
        LinkedListSet<Integer> set3 = set.union(set2);
        assert set3.size() == 4;
        assert set3.contains(1);
        assert set3.contains(2);
        assert set3.contains(3);
        assert set3.contains(4);
        set3 = set2.union(set);
        assert set3.size() == 4;
        assert set3.contains(1);
        assert set3.contains(2);
        assert set3.contains(3);
        assert set3.contains(4);
    }

    @Test
    public void testIntersect() {
        LinkedListSet<Integer> set1 = new LinkedListSet<Integer>();
        LinkedListSet<Integer> set2 = new LinkedListSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(1);
        LinkedListSet<Integer> set3 = set1.intersect(set2);
        assert set3.size() == 2;
    }
}
