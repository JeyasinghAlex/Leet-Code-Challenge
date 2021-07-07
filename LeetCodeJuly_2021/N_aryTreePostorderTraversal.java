import java.util.ArrayList;
import java.util.List;

public class N_aryTreePostorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        postOrder(root);
        return list;
    }

    private void postOrder(Node root) {

        if (root == null) {
            return;
        }

        List<Node> children = root.children;
        for (Node node : children) {
            postOrder(node);
        }
        list.add(root.val);
    }
}
