import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        postOrder(root, ans);
        return ans;
    }

    private void postOrder(TreeNode node, List<Integer> list) {

        if (node == null) {
            return;
        }

        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }

    public List<Integer> postorderTraversalUsingStack(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {

            TreeNode node = st1.pop();
            st2.push(node);

            if (node.left != null) {
                st1.push(node.left);
            }

            if (node.right != null) {
                st1.push(node.right);
            }

        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }
        return ans;
    }

    public List<Integer> postorderTraversalUsingStack_1(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {

            TreeNode  node = st.pop();
            ans.add(0, node.val);

            if (node.left != null) {
                st.push(node.left);
            }

            if (node.right != null) {
                st.push(node.right);
            }

        }
        return ans;
    }
}
