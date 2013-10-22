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
        i1.add(1);
        i1.add(2);
        assert i.equals(i1): "!i.equals(i1)" + i + " " + i1;
        i1.add(3);
        assert !i.equals(i1): "i.equals(i1)" + i + " " + i1;
    }

    @Test
    public void testToString() {
        LinkedListSet<Integer> i = new LinkedListSet<Integer>();
        i.add(1);
        i.add(2);
        i.add(3);
        assert i.toString().equals("{1, 2, 3}");
    }
}
