import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {

    int maxDepth = Integer.MIN_VALUE;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        findDepth(root, 1);
        dfs(root, 1);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {

        if (node == null) {
            return ;
        }

        if (maxDepth == depth) {
            sum += node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    private void findDepth(TreeNode node, int depth) {

        if (node == null) {
            return ;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
        }

        findDepth(node.left, depth + 1);
        findDepth(node.right, depth + 1);
    }


    public int deepestLeavesSum_1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while (!qu.isEmpty()) {
            int len = qu.size();
            sum = 0;
            while (len-- > 0) {
                TreeNode node = qu.poll();
                sum += node.val;
                if (node.left != null) {
                    qu.offer(node.left);
                }

                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
        }
        return sum;
    }
}
