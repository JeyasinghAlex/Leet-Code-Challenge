public class SumOfLeftLeaves {

    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        dfs(root);
        return sum;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        if (left != null && left.left == null && left.right == null) {
            sum += left.val;
        }
        return root;
    }
}
