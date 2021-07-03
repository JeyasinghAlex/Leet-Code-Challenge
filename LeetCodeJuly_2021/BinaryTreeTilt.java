public class BinaryTreeTilt {

    private int sum = 0;
    public int findTilt(TreeNode root) {
        postOrder(root);
        return sum;
    }

    private int postOrder(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int a = postOrder(root.left);
        int b = postOrder(root.right);
        sum += Math.abs(a - b);
        root.val =  a + b + root.val;
        return root.val;
    }
}
