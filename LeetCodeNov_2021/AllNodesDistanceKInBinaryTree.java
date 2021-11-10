import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKInBinaryTree {

    Map<TreeNode, Integer> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        find(root, target);
        search(root, 0, K, res);
        return res;
    }

    private void search(TreeNode node, int dis, int k, List<Integer> list) {

        if (node == null) {
            return ;
        }

        if (map.containsKey(node)) {
            dis = map.get(node);
        }

        if (dis == k) {
            list.add(node.val);
        }

        search(node.left, dis + 1, k, list);
        search(node.right, dis + 1, k, list);
    }

    private void find(TreeNode node, TreeNode target) {

        if (node == null) {
            return ;
        }

        if (node == target) {
            map.put(node, 0);
            return;
        }

        find(node.left, target);
        if (map.containsKey(node.left)) {
            map.put(node, map.get(node.left) + 1);
            return ;
        }

        find(node.right, target);
        if (map.containsKey(node.right)) {
            map.put(node, map.get(node.right) + 1);
            return ;
        }
    }
}
