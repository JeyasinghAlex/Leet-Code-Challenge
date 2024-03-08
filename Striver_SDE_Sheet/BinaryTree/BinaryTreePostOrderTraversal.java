package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode node, List<Integer> list) {

        if (node == null)
            return;

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}
