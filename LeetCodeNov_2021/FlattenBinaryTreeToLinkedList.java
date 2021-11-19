public class FlattenBinaryTreeToLinkedList {

    private TreeNode prev = null;
    public void flatten(TreeNode root) {

        dfs(root);
    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return ;
        }

        dfs(node.right);
        dfs(node.left);
        node.right = prev;
        node.left = null;
        prev = node;
    }
}
