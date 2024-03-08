package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List<Integer> list) {

        if (node == null)
            return;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
