public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }


    private TreeNode dfs(int[] nums, int lo, int hi) {

        if (lo > hi){
            return null;
        }

        int mid = lo + hi >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, lo, mid - 1);
        node.right = dfs(nums, mid + 1, hi);
        return node;
    }
}
