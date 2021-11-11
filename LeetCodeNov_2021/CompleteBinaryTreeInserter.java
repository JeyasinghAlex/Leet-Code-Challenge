import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

    private TreeNode root;
    private Queue<TreeNode> qu;
    public CompleteBinaryTreeInserter(TreeNode root) {
        this.root = root;
        qu = new LinkedList<>();
        qu.offer(root);
    }

    public int insert(int val) {

        while (qu.peek().right != null) {
            qu.offer(qu.peek().left);
            qu.offer(qu.poll().right);
        }
        TreeNode parent = qu.peek();
        TreeNode newNode = new TreeNode(val);
        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
