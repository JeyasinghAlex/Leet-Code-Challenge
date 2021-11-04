import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(1);
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            max = Math.max(max, q.peekLast() - q.peekFirst() + 1);

            for (int i = 0; i < size; i++) {
                root = queue.poll();
                int temp=q.poll();
                if (root.left != null) {
                    queue.offer(root.left);
                    q.offer(2*temp);
                }

                if (root.right != null) {
                    queue.offer(root.right);
                    q.offer((2*temp)+1);
                }
            }
        }
        return max;
    }
}
