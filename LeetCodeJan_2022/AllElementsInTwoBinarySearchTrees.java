import java.util.*;

public class AllElementsInTwoBinarySearchTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        inorder(root1, q1);
        inorder(root2, q2);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                ans.add(q2.poll());
            } else if (q2.isEmpty()) {
                ans.add(q1.poll());
            } else {
                ans.add(q1.peek() > q2.peek() ? q2.poll() : q1.poll());
            }
        }
        return ans;
    }

    private void inorder(TreeNode root, Queue<Integer> q) {

        if (root == null) {
            return ;
        }
        inorder(root.left, q);
        q.offer(root.val);
        inorder(root.right, q);
    }


    private List<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements_1(TreeNode root1, TreeNode root2) {
        preorder(root1);
        preorder(root2);
        Collections.sort(list);
        return list;
    }

    private void preorder(TreeNode root) {

        if (root == null) {
            return ;
        }
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
}
