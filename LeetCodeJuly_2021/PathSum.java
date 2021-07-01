public class PathSum {

    private boolean result = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, targetSum);
        return result;
    }

    private void dfs(TreeNode root, int targetSum) {

        if (root == null || result) {
            return ;
        }

        targetSum = targetSum - root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            result = true;
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}
