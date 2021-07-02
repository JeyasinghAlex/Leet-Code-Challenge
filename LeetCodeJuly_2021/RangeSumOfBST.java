public class RangeSumOfBST {

    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    private void dfs(TreeNode root, int low, int high) {

        if (root == null) {
            return ;
        }

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
}
