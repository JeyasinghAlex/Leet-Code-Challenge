public class MaximumScoreOfAGoodSubArray {

    public int maximumScore(int[] nums, int k) {

        int ans = nums[k];
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int i = k;
        int j = k;
        while (i > 0 || j < n - 1) {
            if (i == 0) {
                ++j;
            } else if (j == n - 1) {
                --i;
            } else if (nums[i - 1] < nums[j + 1]) {
                ++j;
            } else {
                --i;
            }
            min = Math.min(min, Math.min(nums[i], nums[j]));
            ans = Math.max(ans, min * (j - i + 1));
        }
        return ans;
    }
}
