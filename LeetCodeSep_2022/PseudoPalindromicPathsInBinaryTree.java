public class PseudoPalindromicPathsInBinaryTree {

    private int count;
    public int pseudoPalindromicPaths (TreeNode root) {

        preOrder(root, 0);
        return count;

    }

    private void preOrder(TreeNode node, int path) {

        if (node == null) {
            return ;
        }

        path = path ^ (1 << node.val);

        if (node.left == null && node.right == null) {
            if ((path & (path - 1)) == 0) {
                ++count;
            }
            return ;
        }
        preOrder(node.left, path);
        preOrder(node.right, path);

    }

    public int pseudoPalindromicPaths_1 (TreeNode root) {

        int[] freq = new int[10];
        dfs(root, freq);
        return count;
    }

    private void dfs(TreeNode node, int[] freq) {

        if (node == null) {
            return ;
        }

        freq[node.val]++;
        if (node.left == null && node.right == null) {
            if (isPalindrome(freq)) {
                ++count;
            }
        }
        dfs(node.left, freq);
        dfs(node.right, freq);
        freq[node.val]--;
    }

    private boolean isPalindrome(int[] freq) {

        int count = 0;
        for (int i = 0; i < freq.length; ++i) {
            if (freq[i] % 2 == 1) {
                ++count;
            }
        }
        return count == 0 || count == 1;
    }
}
