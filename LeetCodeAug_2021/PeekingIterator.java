import java.util.Iterator;

public class PeekingIterator {
    class Node {

        int val;
        Node next;

        public Node(int val) {
            this(val, null);
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            Node node = new Node(iterator.next());
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (head != null) {
            return new Integer(head.val);
        }
        return new Integer(0);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    public Integer next() {

        if (head != null) {
            Node temp = head;
            head = head.next;
            return new Integer(temp.val);
        }
        return new Integer(0);
    }

    public boolean hasNext() {
        return head != null;
    }
}
