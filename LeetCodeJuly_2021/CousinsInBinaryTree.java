public class CousinsInBinaryTree {

    private int xDepth = -1, yDepth = -1;
    private TreeNode xParant = null, yParant = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return (xParant != yParant) && (xDepth == yDepth);
    }

    private void dfs(TreeNode root, TreeNode parant, int x, int y, int depth) {

        if (root == null) {
            return ;
        }

        if (x == root.val) {
            xParant = parant;
            xDepth = depth;
        } else if (y == root.val) {
            yParant = parant;
            yDepth = depth;
        }

        dfs(root.left, root, x, y, depth + 1);
        dfs(root.right, root, x, y, depth + 1);
    }
}
