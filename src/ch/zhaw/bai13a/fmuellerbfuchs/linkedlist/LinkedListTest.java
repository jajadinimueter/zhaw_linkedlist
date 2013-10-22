package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;


import org.junit.Test;

/**
 */
public class LinkedListTest {
    @Test
    public void testInsertFirst() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.prepend(1);
        assert l.first() == 1;
        assert l.size() == 1;
    }

    @Test
    public void testInsertLast() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.append(1);
        assert l.first() == 1;
        assert l.last() == 1;
        assert l.size() == 1;
    }

    @Test
    public void testSize() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        for (int i = 0; i < 1000; i++) {
            l.append(i);
        }
        assert l.size() == 1000;
    }

    @Test
    public void testContains() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.append(1);
        l.append(8);
        assert l.contains(1);
        assert l.contains(8);
        assert !l.contains(7);
    }

    @Test
    public void testEquals() {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l2.append(1);
        l2.append(2);
        l2.append(3);
        assert l1.equals(l2);
        assert l2.equals(l1);
        assert l1.hashCode() == l2.hashCode();
        l2.append(4);
        assert !l1.equals(l2);
        assert !l2.equals(l1);
        assert l1.hashCode() != l2.hashCode();
        LinkedList<Integer> l3 = new LinkedList<Integer>();
        LinkedList<Integer> l4 = new LinkedList<Integer>();
        l3.append(1);
        l3.append(2);
        l4.append(1);
        l4.append(3);
        assert !l3.equals(l4);
        assert !l4.equals(l3);
        assert l3.hashCode() != l4.hashCode();
        LinkedList<Integer> l5 = new LinkedList<Integer>();
        LinkedList<Integer> l6 = new LinkedList<Integer>();
        l5.append(1);
        l5.append(2);
        l6.append(2);
        l6.append(1);
        assert !l1.equals(l2);
        assert !l2.equals(l1);
        assert l1.hashCode() != l2.hashCode();
    }
}
