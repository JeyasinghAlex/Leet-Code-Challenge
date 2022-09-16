import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    static class Pair {

        int val;
        TreeNode node;

        public Pair(TreeNode node, int val) {
            this.val = val;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if  (root == null) {
            return 0;
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(root, 0));

        int first = 0;
        int last = 0;
        int max = Integer.MIN_VALUE;

        while (!qu.isEmpty()) {

            int len = qu.size();
            int min = qu.peek().val;
            int size = len;

            while (len-- > 0) {

                Pair pair = qu.poll();
                TreeNode node = pair.node;

                int currId = pair.val - min;

                if (len == size - 1) {
                    first = currId;
                }
                if (len == 0) {
                    last = currId;
                }

                if (node.left != null) {
                    qu.offer(new Pair(node.left, 2 * currId + 1));
                }
                if (node.right != null) {
                    qu.offer(new Pair(node.right, 2 * currId + 2));
                }

            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }

    public int widthOfBinaryTree_1(TreeNode root) {
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
