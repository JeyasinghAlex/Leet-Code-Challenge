import java.util.ArrayList;
import java.util.List;

public class N_aryTreePreorderTraversal {

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
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        preOrder(root);
        return list;
    }

    private void preOrder(Node root) {

        if (root == null) {
            return ;
        }

        list.add(root.val);
        List<Node> children = root.children;
        for (Node node : children) {
            preOrder(node);
        }
    }
}

