public class SumOfRootToLeafBinaryNumbers {

    private int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }

    private void preOrder(TreeNode root, int currentNumber) {

        if (root == null) {
            return ;
        }

        currentNumber = (currentNumber << 1) | root.val;
//        currentNumber = currentNumber << 1;
//        currentNumber = currentNumber | root.val;

        if (root.left == null && root.right == null) {
            sum += currentNumber;
            return ;
        }

        preOrder(root.left, currentNumber);
        preOrder(root.right, currentNumber);
    }
}
