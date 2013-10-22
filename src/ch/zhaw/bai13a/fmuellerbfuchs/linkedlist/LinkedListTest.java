package ch.zhaw.bai13a.fmuellerbfuchs.linkedlist;

import junit.framework.TestCase;
import org.junit.Test;

/**
 */
public class LinkedListTest extends TestCase {
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
}
