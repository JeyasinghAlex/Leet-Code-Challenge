import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans);
        return ans;
    }


    private void preOrder(TreeNode node, List<Integer> list) {

        if (node == null) {
            return ;
        }

        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    public List<Integer> preorderTraversalUsingStack(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {

            TreeNode node = st.pop();
            ans.add(node.val);

            if (node.right != null) {
                st.push(node.right);
            }

            if (node.left != null) {
                st.push(node.left);
            }
        }
        return ans;
    }

    public List<Integer> preorderTraversalUsingStack_1(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        while (true) {
            if (node != null) {
                ans.add(node.val);
                st.push(node);
                node = node.left;
            } else {

                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                node = node.right;
            }
        }
        return ans;
    }
}