import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, "", ans);
        return ans;
    }

    private void dfs(TreeNode root, String path, List<String> ans) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path += root.val;
            ans.add(path);
            return ;
        }
        path += root.val + "->";
        dfs(root.left, path, ans);
        dfs(root.right, path, ans);

    }


    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths_1(TreeNode root) {

        dfs(root, "");
        return list;
    }

    private void dfs(TreeNode root, String s) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            s += root.val;
            list.add(s);
            return ;
        }
        s += root.val + "->";
        dfs(root.left, s);
        dfs(root.right, s);
    }
}
