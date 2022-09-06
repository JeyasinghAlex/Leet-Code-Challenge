public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {

        boolean flag = dfs(root);
        return flag ? root : null;
    }

    private boolean dfs(TreeNode node) {

        if (node == null) {
            return false;
        }

        boolean left = dfs(node.left);
        if (!left) {
            node.left = null;
        }
        boolean right = dfs(node.right);
        if (!right) {
            node.right = null;
        }
        return left || right || node.val != 0;
    }

    public TreeNode pruneTree_1(TreeNode root) {

        boolean flag = dfs_1(root);
        if (!flag && root.val == 0) {
            return null;
        }
        return root;
    }

    private boolean dfs_1(TreeNode node) {

        if (node == null) {
            return false;
        }

        boolean left = dfs_1(node.left);
        if (!left) {
            node.left = null;
        }
        boolean right = dfs_1(node.right);
        if (!right) {
            node.right = null;
        }

        if (!left && !right && node.val == 0) {
            return false;
        }
        return true;
    }
}
