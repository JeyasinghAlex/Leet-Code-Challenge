package WeeklyContest_311_18_09_22;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseOddLevelsOfBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

        TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> qu = new LinkedList<>();

        if (root == null) {
            return null;
        }

        int level = 0;

        TreeNode[] arr = null;
        int idx = 0;

        qu.offer(root);

        while (!qu.isEmpty()) {

            int len = qu.size();

            if (level % 2 == 1) {
                arr = new TreeNode[len];
                idx = 0;
            }

            while (len-- > 0) {

                TreeNode node = qu.poll();

                if (level % 2 == 1)
                    arr[idx++] = node;

                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
            if (level % 2 == 1) {
                reverse(arr);
            }
            ++level;
        }
        return root;
    }

    private void reverse(TreeNode[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            int temp = arr[i].val;
            arr[i].val = arr[j].val;
            arr[j].val = temp;
            ++i;
            --j;
        }
    }
}
