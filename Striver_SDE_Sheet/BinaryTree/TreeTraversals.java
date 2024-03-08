package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversals {

    public List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        getTreeTraversal(root, preOrder, inOrder, postOrder);
        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);
        return ans;
    }

    public void getTreeTraversal(TreeNode node, List<Integer> preOrder, List<Integer> inOrder, List<Integer> postOrder) {

        if (node == null) {
            return;
        }

        preOrder.add(node.val);
        getTreeTraversal(node.left, preOrder, inOrder, postOrder);
        inOrder.add(node.val);
        getTreeTraversal(node.right, preOrder, inOrder, postOrder);
        postOrder.add(node.val);

    }
}
