import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    private List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {

        if (root != null) {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}