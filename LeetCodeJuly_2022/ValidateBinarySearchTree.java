import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, long minVal, long maxVal) {

        if (node == null) {
            return true;
        }
        if (node.val >= maxVal || node.val <= minVal) {
            return false;
        }
        return isValidBST(node.left, minVal, node.val) && isValidBST(node.right, node.val, maxVal);
    }

    public boolean isValidBST_1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
