package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode node, List<Integer> list) {

        if (node == null)
            return;

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}
