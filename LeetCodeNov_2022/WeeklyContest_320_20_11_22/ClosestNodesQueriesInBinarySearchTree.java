package WeeklyContest_320_20_11_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClosestNodesQueriesInBinarySearchTree {

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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, list);
        Collections.sort(list);

        int min = 0;
        int max = 0;
        int n = list.size();

        for (int querie : queries) {
            int idx = lowerBond(list, querie);
            if (idx >= n) {
                max = -1;
            } else {
                max = list.get(idx);
            }

            if (idx >= n) {
                min = list.get(idx - 1);
            } else if (idx == 0 && list.get(idx) != querie){
                min = -1;
            }else if (list.get(idx) != querie){
                min = list.get(idx - 1);
            } else {
                min = list.get(idx);
            }
            ans.add(Arrays.asList(min, max));
        }
        return ans;
    }

    private int lowerBond(List<Integer> list, int target) {

        int lo = 0;
        int hi = list.size();
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (target > list.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private void dfs(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }
}
