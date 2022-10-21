package WeeklyContest_307_08_21_22;

import java.util.*;

public class AmountOfTimeForBinaryTreeToBeInfected {

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

    public int amountOfTime(TreeNode node, int start) {

        if (node == null) {
            return 0;
        }

        Map<Integer, Set<Integer>> map = buidGraph(node);
        Set<Integer> visited = new HashSet<>();
        dfs(start, map, visited, 0);
        return ans;
    }

    int ans = 0;
    private void dfs(int curr, Map<Integer, Set<Integer>> map, Set<Integer> visited, int count) {

        if (visited.contains(curr)) {
            return;
        }

        ans = Math.max(ans, count);

        visited.add(curr);
        for (int v : map.get(curr)) {
            dfs(v, map, visited, count + 1);
        }
    }

    private Map<Integer, Set<Integer>> buidGraph(TreeNode root) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while (!qu.isEmpty()) {

            int len = qu.size();

            while (len-- > 0) {
                TreeNode node = qu.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;

                map.putIfAbsent(node.val, new HashSet<>());

                if (left != null) {
                    map.putIfAbsent(left.val, new HashSet<>());
                    map.get(node.val).add(left.val);
                    map.get(left.val).add(node.val);
                    qu.offer(left);
                }
                if (right != null) {
                    map.putIfAbsent(right.val, new HashSet<>());
                    map.get(node.val).add(right.val);
                    map.get(right.val).add(node.val);
                    qu.offer(right);
                }
            }
        }
        return map;
    }
}
