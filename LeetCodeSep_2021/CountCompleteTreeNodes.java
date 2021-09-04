public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int leftCount = 0;
        int rightCount = 0;

        TreeNode leftNode = root;
        while (leftNode != null) {
            ++leftCount;
            leftNode = leftNode.left;
        }

        TreeNode rightNode = root;
        while (rightNode != null) {
            ++rightCount;
            rightNode = rightNode.right;
        }

        if (leftCount == rightCount) {
            return (int) Math.pow(2, rightCount) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int count = 0;
    public int countNodes_1(TreeNode root) {

        preOrder(root);
        return count;
    }

    private void preOrder(TreeNode node) {

        if (node != null) {
            ++count;
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
