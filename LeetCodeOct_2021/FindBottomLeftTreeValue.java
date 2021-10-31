import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {

        dfs(root, 1);
        return leftMost;
    }

    int maxDepth = 0;
    int leftMost = 0;

    private void dfs(TreeNode node, int depth) {

        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            leftMost = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int bfs(TreeNode root) {

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        TreeNode node = root;
        while (!qu.isEmpty()) {
            node = qu.poll();
            if (node.right != null) {
                qu.offer(node.right);
            }
            if (node.left != null) {
                qu.offer(node.left);
            }
        }
        return node.val;
    }

    public int findBottomLeftValue_1(TreeNode root) {

        int depth = findDepth(root);
        findMax(root, depth, 1);
        return max;
    }

    int max = Integer.MIN_VALUE;
    boolean flag = false;
    private int findMax(TreeNode node, int depth, int count) {

        if (node == null || flag) {
            return 0;
        }

        if (count == depth) {
            max = Math.max(max, node.val);
            flag = true;
        }
        return 1 + Math.max(findMax(node.left, depth, count + 1), findMax(node.right, depth, count + 1));
    }

    private int findDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        return 1 + Math.max(findDepth(node.left), findDepth(node.right));
    }
}
