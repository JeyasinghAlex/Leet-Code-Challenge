import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> res = new ArrayList<>();
        postOrder(root, new HashMap<>(), res);
        return res;
    }

    private String postOrder(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {

        if (node == null) {
            return "#";
        }

        String leftVal = postOrder(node.left, map, res);
        String rightVal = postOrder(node.right, map, res);
        String s = node.val + "," + leftVal + "," + rightVal;
        map.put(s, map.getOrDefault(s, 0) + 1);
        if (map.get(s) == 2) {
            res.add(node);
        }
        return s;
    }
}