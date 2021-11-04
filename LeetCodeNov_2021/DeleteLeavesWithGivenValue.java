public class DeleteLeavesWithGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {

        if (root.left != null) {
            root.left = removeLeafNodes(root.left, target);
        }

        if (root.right != null) {
            root.right = removeLeafNodes(root.right, target);
        }

        return (root.left == null && root.right == null && root.val == target) ? null : root;
    }


    public TreeNode removeLeafNodes_1(TreeNode root, int target) {
        dfs(root, target);
        if (root.left == null && root.right == null && root.val == target) {
            root = null;
        }
        return root;
    }

    private boolean dfs(TreeNode node, int target) {

        if (node == null) {
            return false;
        }

        if (dfs(node.left, target)) {
            node.left = null;
        }

        if (dfs(node.right, target)) {
            node.right = null;
        }

        if (node.left == null && node.right == null && node.val == target) {
            return true;
        }
        return false;
    }
}
