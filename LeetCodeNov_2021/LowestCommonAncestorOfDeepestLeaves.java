public class LowestCommonAncestorOfDeepestLeaves {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return lca;
    }

    int maxDepth = Integer.MIN_VALUE;
    TreeNode lca = null;

    private int dfs(TreeNode node, int depth) {

        if (depth > maxDepth) {
            maxDepth = depth;
        }

        if (node == null) {
            return depth;
        }

        int left = dfs(node.left, depth + 1);
        int right = dfs(node.right, depth + 1);

        if (left == maxDepth && right == maxDepth) {
            lca = node;
        }
        return Math.max(left, right);
    }
}