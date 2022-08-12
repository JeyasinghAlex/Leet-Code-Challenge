public class LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        else if (right == null) {
            return left;
        }
        else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {

        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor_1(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor_1(root.right, p, q);
        } else {
            return root;
        }
    }
}
