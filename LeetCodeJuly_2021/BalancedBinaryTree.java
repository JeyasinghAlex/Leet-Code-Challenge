public class BalancedBinaryTree {

    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {

        if (root == null || !result)
            return 0;

        int l = dfs(root.left);
        int r = dfs(root.right);

        if (Math.abs(l - r) > 1) {
            result = false;
        }

        return 1 + Math.max(l, r);
    }
}
