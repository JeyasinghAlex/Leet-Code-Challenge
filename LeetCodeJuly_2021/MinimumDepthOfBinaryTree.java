public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        return (l == 0 || r == 0) ? l + r + 1 : 1 + Math.min(l, r);

    }
}
