public class CountGoodNodesInBinaryTree {

    int count = 0;
    public int goodNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode node, int max) {

        if (node == null) {
            return ;
        }

        if (node.val >= max) {
            ++count;
            max = node.val;
        }

        dfs(node.left, max);
        dfs(node.right, max);
    }
}
