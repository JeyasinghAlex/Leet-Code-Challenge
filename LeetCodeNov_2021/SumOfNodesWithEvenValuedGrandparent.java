import java.util.ArrayList;
import java.util.List;

public class SumOfNodesWithEvenValuedGrandparent {

    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {

        dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {

        if (current == null) {
            return ;
        }

        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += current.val;
        }

        dfs(current.left, current, parent);
        dfs(current.right, current, parent);
    }



    public int sumEvenGrandparent_1(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return sum;
    }

    private void dfs(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        list.add(node.val);
        int size = list.size();
        if (size >= 3 && list.get(size - 3) % 2 == 0) {
            sum += node.val;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        list.remove(size - 1);
    }
}
