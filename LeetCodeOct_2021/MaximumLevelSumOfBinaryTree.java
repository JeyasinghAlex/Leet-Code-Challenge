import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {

    public int maxLevelSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int level = 0;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        while (!qu.isEmpty()) {

            int len = qu.size();
            int sum = 0;
            level++;
            while (len-- > 0) {
                TreeNode temp = qu.poll();
                sum += temp.val;
                if (temp.left != null) {
                    qu.offer(temp.left);
                }
                if (temp.right != null) {
                    qu.offer(temp.right);
                }
            }
            if (sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }
}
