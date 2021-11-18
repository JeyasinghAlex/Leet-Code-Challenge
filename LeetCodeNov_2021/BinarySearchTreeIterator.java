import java.util.PriorityQueue;
import java.util.Queue;

public class BinarySearchTreeIterator {

    private Queue<Integer> qu;
    public BinarySearchTreeIterator(TreeNode root) {
        this.qu = new PriorityQueue<>();
        inOrder(root);
    }

    private void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        qu.offer(node.val);
        inOrder(node.right);
    }

    public int next() {
        int val = qu.poll();
        return val;
    }

    public boolean hasNext() {
        return !qu.isEmpty();
    }
}
