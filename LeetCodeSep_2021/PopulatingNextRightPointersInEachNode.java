import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        qu.add(null);
        while (!qu.isEmpty()) {
            Node node = qu.poll();
            if (node == null && qu.isEmpty()) {
                return root;
            } else if (node == null) {
                qu.add(null);
                continue;
            } else {
                node.next = qu.peek();
                if (node.left != null) {
                    qu.add(node.left);
                }
                if (node.right != null) {
                    qu.add(node.right);
                }
            }
        }
        return root;
    }
}
