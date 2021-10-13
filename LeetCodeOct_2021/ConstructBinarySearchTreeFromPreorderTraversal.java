public class ConstructBinarySearchTreeFromPreorderTraversal {

    public TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = null;
        for (int n : preorder) {
            root = dfs(n, root);
        }
        return root;
    }

    private TreeNode dfs(int val, TreeNode currNode) {

        if (currNode == null) {
            return new TreeNode(val);
        }

        if (val <= currNode.val) {
            currNode.left =  dfs(val, currNode.left);
        } else {
            currNode.right = dfs(val, currNode.right);
        }
        return currNode;
    }
}
