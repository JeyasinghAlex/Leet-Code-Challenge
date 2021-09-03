import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_II {

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
        qu.offer(root);
        qu.offer(null);
        while (!qu.isEmpty()) {

            Node node = qu.poll();
            if (node == null && qu.isEmpty()) {
                return root;
            } else if (node == null) {
                qu.offer(null);

            } else {
                node.next = qu.peek();
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
        }
        return root;
    }


    public Node connect_1(Node root) {

        if (root == null) {
            return root;
        }

        Queue<Node> qu = new LinkedList<>();
        qu.offer(root);
        qu.offer(null);
        while (!qu.isEmpty()) {

            int len = qu.size();
            while (len-- > 0) {
                Node node = qu.poll();
                if (node == null && qu.isEmpty()) {
                    return root;
                }
                if (node == null) {
                    continue;
                }
                node.next = qu.peek();
                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
            qu.offer(null);
        }
        return root;
    }
}
