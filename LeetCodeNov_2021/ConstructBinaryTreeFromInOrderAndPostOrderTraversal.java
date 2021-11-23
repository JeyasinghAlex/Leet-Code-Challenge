import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInOrderAndPostOrderTraversal {

    private Map<Integer, Integer> map;
    private int postOrderIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        postOrderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postOrder, int left, int right) {

        if (left > right || postOrderIndex < 0) {
            return null;
        }

        int val = postOrder[postOrderIndex--];
        TreeNode node = new TreeNode(val);

        node.right = helper(postOrder, map.get(val) + 1, right);
        node.left = helper(postOrder, left, map.get(val) - 1);
        return node;
    }
}
