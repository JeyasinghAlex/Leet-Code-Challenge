import java.util.*;

public class TopViewOfBinaryTree {

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }

    static class Pair {
        int line;
        Node node;

        public Pair (Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }

    public List<Integer> topView(Node root) {

        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> lineVsVal = new TreeMap<>();
        Queue<Pair> qu = new LinkedList<>();

        qu.offer(new Pair(root, 0));

        while (!qu.isEmpty()) {

            int len = qu.size();

            while (len-- > 0) {

                Pair pair = qu.poll();
                int line = pair.line;
                Node node = pair.node;

                if (node.left != null) {
                    qu.offer(new Pair(node.left, line - 1));
                }

                if (node.right != null) {
                    qu.offer(new Pair(node.right, line + 1));
                }

                if (!lineVsVal.containsKey(line)) {
                    lineVsVal.put(line, node.data);
                }
            }
        }

        for (int val : lineVsVal.values()) {
            ans.add(val);
        }
        return ans;
    }
}
