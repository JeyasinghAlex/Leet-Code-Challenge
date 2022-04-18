public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return ans;
    }

    private int count = 0;
    private int ans = 0;
    private void inOrder(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        inOrder(node.left, k);
        ++count;
        if (count == k) {
            ans = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}
