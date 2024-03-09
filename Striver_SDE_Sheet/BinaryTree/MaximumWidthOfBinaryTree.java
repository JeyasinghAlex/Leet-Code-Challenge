package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

class Pair {

    TreeNode node;
    int val;

    public Pair(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
}

public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        int ans = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(root, 0));

        int max = 0;
        while (!qu.isEmpty()) {

            int len = qu.size();
            int size = len;
            int left = 0;
            int right = 0;

            while (len-- > 0) {

                Pair pair = qu.poll();
                TreeNode node = pair.node;
                int currentId = pair.val;

                if (len == size - 1) {
                    left = pair.val;
                }

                if (len == 0) {
                    right = pair.val;
                }

                if (node.left != null) {
                    qu.offer(new Pair(node.left, currentId * 2 + 1));
                }
                if (node.right != null) {
                    qu.offer(new Pair(node.right, currentId * 2 + 2));
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
