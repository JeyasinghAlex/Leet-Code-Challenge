import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        for (int i = 0; i < depth - 2; ++i) {

            int len = qu.size();
            while (len-- > 0) {
                TreeNode temp = qu.poll();
                if (temp.left != null) {
                    qu.offer(temp.left);
                }
                if (temp.right != null) {
                    qu.offer(temp.right);
                }
            }
        }

        while (!qu.isEmpty()) {
            TreeNode node = qu.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }
        return root;
    }
}
