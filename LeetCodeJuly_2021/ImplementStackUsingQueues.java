public class ImplementStackUsingQueues {

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

    /** Initialize your data structure here. */
    private Node head;
    public ImplementStackUsingQueues() {
        this.head = null;
    }

    /** Push element x onto stack. */
    public void push(int x) {

        if (head != null) {
            head = new Node(x, head);
        } else {
            head = new Node(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Node temp = head;
        head = head.next;
        return temp.val;
    }

    /** Get the top element. */
    public int top() {
        return head.val;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return head == null;
    }
}
