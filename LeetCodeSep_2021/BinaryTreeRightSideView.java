import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        rightSideView(root, 0, ans);
        return ans;
    }

    private void rightSideView(TreeNode node, int level, List<Integer> list) {

        if (node == null) {
            return ;
        }

        if (level == list.size()) {
            list.add(node.val);
        }

        rightSideView(node.right, level + 1, list);
        rightSideView(node.left, level + 1, list);
    }

    public List<Integer> rightSideView_1(TreeNode root) {

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
