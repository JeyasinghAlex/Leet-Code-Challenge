public class SumRootToLeafNumbers {

    int total = 0;
    public int sumNumbers(TreeNode root) {

        preOrder(root, 0);
        return total;
    }

    private void preOrder(TreeNode node, int val) {

        if (node == null) {
            return ;
        }

        if (node.left == null && node.right == null) {
            total += (val * 10) + node.val;
            return ;
        }

        int temp = (val * 10) + node.val;
        preOrder(node.left, temp);
        preOrder(node.right, temp);
    }
}
