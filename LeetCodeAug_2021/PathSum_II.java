import java.util.ArrayList;
import java.util.List;

public class PathSum_II {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, ans, list, targetSum);
        return ans;
    }

    private void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> list, int target) {

        if (root == null) {
            return ;
        }
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            list.add(root.val);
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        dfs(root.left, ans, list, target);
        dfs(root.right, ans, list, target);
        list.remove(list.size() - 1);
    }
}
