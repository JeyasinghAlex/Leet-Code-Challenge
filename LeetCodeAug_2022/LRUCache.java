import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    int capacity;

    public LRUCache(int capacity) {
        join(head, tail);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                if (tail.prev != head) {
                    map.remove(tail.prev.key);
                    remove(tail.prev);
                }
            }
            Node node = new Node(key, value);
            moveToHead(node);
            map.put(key, node);
        }
    }

    public void join(Node n1, Node n2) {
        n1.next = n2;
        n2.prev = n1;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(Node node) {
        Node next = head.next;
        join(head, node);
        join(node, next);
    }
}
