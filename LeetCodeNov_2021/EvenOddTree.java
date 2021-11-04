import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {

        if (root == null) {
            return false;
        }

        int level = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean flag = false;
        while (!qu.isEmpty()) {

            flag = !flag;
            int prev = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            int len = qu.size();
            while (len-- > 0) {

                TreeNode node = qu.poll();

                if (level % 2 == 0 && node.val % 2 == 1) {
                    if (node.val > prev) {
                        prev = node.val;
                    } else {
                        return false;
                    }
                } else if (level % 2 == 1 && node.val % 2 == 0){
                    if (node.val < prev) {
                        prev = node.val;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

                if (node.left != null) {
                    qu.offer(node.left);
                }
                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }
}
