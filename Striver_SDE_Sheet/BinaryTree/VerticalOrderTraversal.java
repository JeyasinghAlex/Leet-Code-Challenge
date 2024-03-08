package BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {

    class Node {

        int line;
        TreeNode treeNode;

        public Node (TreeNode treeNode, int line) {
            this.line = line;
            this.treeNode = treeNode;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Node> qu = new LinkedList<>();

        qu.offer(new Node(root, 0));

        while (!qu.isEmpty()) {

            int len = qu.size();

            Map<Integer, Queue<Integer>> sMap = new TreeMap<>();

            while (len-- > 0) {

                Node node = qu.poll();

                int line = node.line;
                TreeNode treeNode = node.treeNode;

                if (treeNode.left != null) {
                    qu.offer(new Node(treeNode.left, line - 1));
                }

                if (treeNode.right != null) {
                    qu.offer(new Node(treeNode.right, line + 1));
                }

                sMap.putIfAbsent(line, new PriorityQueue<>());
                sMap.get(line).offer(treeNode.val);
            }

            for (Map.Entry<Integer, Queue<Integer>> entry : sMap.entrySet()) {
                int line = entry.getKey();
                map.putIfAbsent(line, new ArrayList<>());
                Queue<Integer> pq = entry.getValue();
                while (!pq.isEmpty()) {
                    map.get(line).add(pq.poll());
                }
            }
        }

        for (List<Integer> list : map.values()) {
            ans.add(list);
        }
        return ans;
    }
}
