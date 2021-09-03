import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while (!qu.isEmpty()) {
            int len = qu.size();
            while (len-- > 0) {
                TreeNode node = qu.poll();
                if (len == 0) {
                    list.add(node.val);
                }

                if (node.left != null) {
                    qu.offer(node.left);
                }

                if (node.right != null) {
                    qu.offer(node.right);
                }
            }
        }
        return list;
    }
}
