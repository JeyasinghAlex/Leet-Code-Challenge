import java.util.List;

public class MaximumDepthOfN_aryTree {

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

    private int max = 0;
    public int maxDepth(Node root) {

        dfs(root, 1);
        return max;
    }

    private void dfs(Node root, int depth) {
        if (root == null) {
            return ;
        }
        max = Math.max(max, depth);
        List<Node> children = root.children;
        for (Node node : children) {
            dfs(node, depth + 1);
        }
    }
}
