public class MinimumDistanceBetweenBSTNodes {

    private int min = Integer.MAX_VALUE;
    private int prev = -1;
    public int minDiffInBST(TreeNode root) {

        inorder(root);
        return min;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return ;
        }

        inorder(root.left);
        if (prev >= 0) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }
}
