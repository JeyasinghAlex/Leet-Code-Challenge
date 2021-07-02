public class IncreasingOrderSearchTree {


    private TreeNode ans;
    private TreeNode tail;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return ans;
    }

    private void inOrder(TreeNode root) {

        if (root == null) {
            return ;
        }

        inOrder(root.left);
        constructTree(root.val);
        inOrder(root.right);
    }

    private void constructTree(int val) {

        if (ans == null) {
            ans = new TreeNode(val);
            tail = ans;
        } else {
            tail.right = new TreeNode(val);
            tail = tail.right;
        }
    }
}
