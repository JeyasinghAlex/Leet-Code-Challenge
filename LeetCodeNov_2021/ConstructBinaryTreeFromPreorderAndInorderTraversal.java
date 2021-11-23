import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> map;
    private int preOrderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.preOrderIndex = 0;
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int val = preorder[preOrderIndex++];
        TreeNode node = new TreeNode(val);
        node.left = helper(preorder, left, map.get(val) - 1);
        node.right = helper(preorder, map.get(val) + 1, right);
        return node;
    }

    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
