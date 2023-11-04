package InterviewQuestions;

/**
 * Oyo
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isValid(root, root);
    }

    private boolean isValid(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null || p != null && q == null || p.val != q.val) {
            return false;
        }

        return isValid(p.left, q.right) &&  isValid(p.right, q.left);
    }
}
