import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_ary_TreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> qu = new LinkedList();
        qu.offer(root);
        while (!qu.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = qu.size();

            while (len-- > 0) {
                Node temp = qu.poll();
                for (Node node : temp.children) {
                    qu.offer(node);
                }
                list.add(temp.val);
            }
            ans.add(list);
        }
        return ans;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
