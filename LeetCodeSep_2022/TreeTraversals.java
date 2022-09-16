import java.util.ArrayList;
import java.util.List;

public class TreeTraversals {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();

        traversal(root, inOrder, preOrder, postOrder);
        ans.add(inOrder);
        ans.add(preOrder);
        ans.add(postOrder);
        return ans;
    }

    private static void traversal(BinaryTreeNode<Integer> node, List<Integer> in, List<Integer> pre, List<Integer> post) {

        if (node == null) {
            return ;
        }

        pre.add(node.data);
        traversal(node.left, in, pre, post);
        in.add(node.data);
        traversal(node.right, in, pre, post);
        post.add(node.data);
    }
}
