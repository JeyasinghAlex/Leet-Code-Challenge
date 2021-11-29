public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int val) {

        if (root == null) {
            return null;
        } else if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {

            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }
}
