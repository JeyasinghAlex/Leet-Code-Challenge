import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLeftSideView {

        List<Integer> leftSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        leftSideView(root, 0, ans);
        return ans;
    }


    private void leftSideView(TreeNode node, int level, List<Integer> list) {

        if (node == null) {
            return ;
        }

        if (level == list.size()) {
            list.add(node.val);
        }
        leftSideView(node.left, level + 1, list);
        leftSideView(node.right, level + 1, list);
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

            list.add(qu.peek().val);

            while (len-- > 0) {

                TreeNode node = qu.poll();

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
