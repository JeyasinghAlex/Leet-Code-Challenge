import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }

    private void inOrder(TreeNode node, List<Integer> list) {

        if (node == null) {
            return ;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }


    public List<Integer> inorderTraversalUsingStack(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        while (true) {

            if (node != null) {
                st.push(node);
                node = node.left;
            } else {

                if (st.isEmpty()) {
                    break;
                }

                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }
}
