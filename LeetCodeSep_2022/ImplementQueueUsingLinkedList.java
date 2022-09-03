public class ImplementQueue {

    class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    ImplementQueue() {
        // Implement the Constructor
    }

    private Node head;
    private Node tail;
    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return head == null;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    int dequeue() {
        // Implement the dequeue() function
        if (head == null) {
            return -1;
        }

        int val = head.val;
        head = head.next;
        return val;
    }

    int front() {
        // Implement the front() function
        if (head == null) {
            return -1;
        }
        return head.val;
    }
}
