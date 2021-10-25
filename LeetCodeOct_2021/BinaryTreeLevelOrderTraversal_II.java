import java.util.*;

public class BinaryTreeLevelOrderTraversal_II {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Stack<List<Integer>> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, st);
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    private void bfs(TreeNode node, Stack<List<Integer>> st) {

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(node);
        while (!qu.isEmpty()) {
            int len = qu.size();
            List<Integer> list = new ArrayList<>();
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
            st.push(list);
        }
    }
}
