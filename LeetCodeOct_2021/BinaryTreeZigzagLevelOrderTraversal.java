import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<List<Integer>> ans) {

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(node);
        boolean flag = true;
        while (!qu.isEmpty()) {

            int len = qu.size();
            List<Integer> list = new ArrayList<>();
            flag = !flag;
            while (len-- > 0) {
                TreeNode temp = qu.poll();

                if (flag) {
                    list.add(0, temp.val);
                } else {
                    list.add(temp.val);
                }

                if (temp.left != null) {
                    qu.offer(temp.left);
                }
                if (temp.right != null) {
                    qu.offer(temp.right);
                }
            }
            ans.add(list);
        }
    }
}
