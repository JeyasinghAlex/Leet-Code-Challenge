import java.util.*;

public class BottomViewOfBinaryTree {

    class Node {

        int line;
        int val;
        Node left;
        Node right;
    }

    public List<Integer> bottomView(Node root) {

        Queue<Node> qu = new LinkedList<>();

        Map<Integer, Integer> lineVsValue = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        root.line = 0;
        qu.offer(root);

        while (!qu.isEmpty()) {

            int len = qu.size();

            while (len-- > 0) {

                Node node = qu.poll();
                int line = node.line;
                int data = node.val;

                if (node.left != null) {
                    Node left = node.left;
                    left.line = line - 1;
                    qu.offer(left);
                }
                if (node.right != null) {
                    Node right = node.right;
                    right.line = line + 1;
                    qu.offer(right);
                }
                lineVsValue.put(line, data);
            }
        }

        for (int n : lineVsValue.values()) {
            ans.add(n);
        }
        return ans;
    }
}
