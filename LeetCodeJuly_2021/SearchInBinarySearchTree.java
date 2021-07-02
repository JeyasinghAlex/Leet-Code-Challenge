public class SearchInBinarySearchTree {

    private TreeNode result;
    public TreeNode searchBST(TreeNode root, int val) {
        preOrder(root, val);
        return result;
    }

    private void preOrder(TreeNode root, int val) {

        if (root == null || result != null) {
            return ;
        }

        if (root.val == val) {
            result = root;
            return ;
        }
        preOrder(root.left, val);
        preOrder(root.right, val);
    }
}
