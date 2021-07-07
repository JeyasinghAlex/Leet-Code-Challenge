public class ConstructStringFromBinaryTree {


    private StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder();
        preOrder(root);
        return sb.toString();
    }

    private void preOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            preOrder(root.left);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            preOrder(root.right);
            sb.append(")");
        }

    }
}
