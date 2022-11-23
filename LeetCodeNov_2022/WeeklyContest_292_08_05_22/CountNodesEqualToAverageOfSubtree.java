package WeeklyContest_292_08_05_22;

public class CountNodesEqualToAverageOfSubtree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int averageOfSubtree(TreeNode root) {

        dfs(root);
        return ans;
    }

    private int ans = 0;
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int sum = 0;
        int count = 0;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        sum = node.val + left[0] + right[0];
        count = 1 + left[1] + right[1];
        ans += sum / count == node.val ? 1 : 0;

        return new int[]{sum, count};
    }
}
