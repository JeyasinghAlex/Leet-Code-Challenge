import java.util.ArrayList;
import java.util.List;

public class RootToNodePathInBinaryTree {

    public int[] solve(TreeNode root, int target) {

        List<Integer> list = new ArrayList<>();

        preOrder(root, target, list);

        int n = list.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; ++i) {
            ans[i] = list.get(n - i - 1);
        }
        return ans;
    }

    private boolean preOrder(TreeNode node, int target, List<Integer> list) {

        if (node == null) {
            return false;
        }

        if (node.val == target) {
            list.add(node.val);
            return true;
        }

        boolean left = preOrder(node.left, target, list);

        boolean right = preOrder(node.right, target, list);

        if (left || right) {
            list.add(node.val);
            return true;
        }
        return false;
    }
}
