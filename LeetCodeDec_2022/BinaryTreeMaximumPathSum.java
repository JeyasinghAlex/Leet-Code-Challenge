public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return max;
    }

    int max = Integer.MIN_VALUE;
    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
