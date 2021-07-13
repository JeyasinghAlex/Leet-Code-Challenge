public class ImplementQueueUsingStacks {

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /** Initialize your data structure here. */
    private Node head;
    private Node tail;
    public ImplementQueueUsingStacks() {
        this.head = null;
        this.tail = null;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Node temp = head;
        head = head.next;
        return temp.val;
    }

    /** Get the front element. */
    public int peek() {
        return head.val;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return head == null;
    }
}
