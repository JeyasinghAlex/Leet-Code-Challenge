package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left, right;
    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LeftViewOfBinaryTree {

        List<Integer> leftView(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> qu = new LinkedList<>();
        bfs(root, list, qu);
        return list;
    }

    private void bfs(Node node, List<Integer> list, Queue<Node> qu) {

        if (node == null)
            return;

        qu.offer(node);
        while (!qu.isEmpty()) {
            int len = qu.size();
            list.add(qu.peek().data);
            while (len-- > 0) {
                node = qu.poll();
                if (node.left != null)
                    qu.offer(node.left);

                if (node.right != null)
                    qu.offer(node.right);
            }
        }
    }
}
