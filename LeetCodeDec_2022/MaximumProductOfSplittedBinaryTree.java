public class MaximumProductOfSplittedBinaryTree {

    private long max;
    private long sum;

    private int prefixSum(TreeNode node) {
        if(node == null)
            return 0;

        node.val += prefixSum(node.left) + prefixSum(node.right);
        return node.val;
    }

    private void dfs(TreeNode node) {
        if(node == null)
            return;

        max = Math.max(max, node.val * (sum - node.val));
        dfs(node.left);
        dfs(node.right);
    }

    public int maxProduct(TreeNode root) {

        sum = prefixSum(root);
        dfs(root);
        return (int)(max % 1000000007);
    }
}
