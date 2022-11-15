package WeeklyContest_319_13_11_22;

import java.util.*;

public class MinimumNumberOfOperationsToSortBinaryTreeByLevel {

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

    public int minimumOperations(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        int res = 0;
        while (!level.isEmpty()) {
            List<TreeNode> level2 = new ArrayList<>();
            List<Integer> sort = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            for (TreeNode n : level) {
                if (n.left != null) {
                    level2.add(n.left);
                }
                if (n.right != null) {
                    level2.add(n.right);
                }
                sort.add(n.val);
                list.add(n.val);
            }
            Collections.sort(sort);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sort.size(); i++) {
                map.put(sort.get(i), i);
            }
            boolean[] visited = new boolean[sort.size()];
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    int current = i;
                    int size = 0;
                    while (!visited[current]) {
                        visited[current] = true;
                        current = map.get(list.get(current));
                        size++;
                    }
                    res += size - 1;
                }
            }
            level = level2;
        }
        return res;
    }
}
