import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans);
        return ans;
    }

    private void bfs(TreeNode node, List<List<Integer>> ans) {

        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> list = null;
        qu.offer(node);
        while (!qu.isEmpty()) {
            int len = qu.size();
            list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode temp = qu.poll();
                if (temp.left != null) {
                    qu.offer(temp.left);
                }
                if (temp.right != null) {
                    qu.offer(temp.right);
                }
                list.add(temp.val);
            }
            ans.add(list);
        }
    }
}
