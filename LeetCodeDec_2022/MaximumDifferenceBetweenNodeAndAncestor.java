public class MaximumDifferenceBetweenNodeAndAncestor {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, root.val, root.val);
        return ans;
    }

    private int ans = 0;
    private void dfs(TreeNode node, int currMin, int currMax) {

        if (node == null) {
            return ;
        }
        currMin = Math.min(currMin, node.val);
        currMax = Math.max(currMax, node.val);
        int diff = Math.abs(currMax - currMin);
        ans = Math.max(ans, diff);

        dfs(node.left, currMin, currMax);
        dfs(node.right, currMin, currMax);
    }
}
