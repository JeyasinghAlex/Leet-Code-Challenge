import java.util.PriorityQueue;
import java.util.Queue;

public class SecondMinimumNodeInBinaryTree {

    private Queue<Integer> qu = new PriorityQueue<>();
    public int findSecondMinimumValue(TreeNode root) {

        dfs(root);
        int min = qu.peek();
        while (!qu.isEmpty()) {

            if (qu.peek() != min) {
                return qu.poll();
            }
            qu.poll();
        }
        return -1;
    }

    private void dfs(TreeNode root) {

        if (root == null) {
            return ;
        }

        dfs(root.left);
        qu.offer(root.val);
        dfs(root.right);
    }
}
