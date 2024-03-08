package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
};

public class AllRootToLeafPathsInBinaryTree {


    public List<String> allRootToLeaf(BinaryTreeNode root) {
        // Write your code here.
        List<String> ans = new ArrayList<>();
        dfs(root, ans, "");
        return ans;
    }

    private void dfs(BinaryTreeNode node, List<String> list, String s) {

        if (node == null) {
            return ;
        }

        s = s + node.data + " ";

        if (node.left == null && node.right == null) {
            list.add(s.substring(0, s.length() - 1));
            return;
        }

        dfs(node.left, list, s);
        dfs(node.right, list, s);

    }
}
