public class UniValuedBinaryTree {

    private boolean result = true;
    public boolean isUniValTree(TreeNode root) {
        dfs(root, root.val);
        return result;
    }

    private void dfs(TreeNode root, int n) {

        if (root == null || !result) {
            return;
        }

        if (root.val != n) {
            result = false;
            return ;
        }

        dfs(root.left, n);
        dfs(root.right, n);
    }
}
