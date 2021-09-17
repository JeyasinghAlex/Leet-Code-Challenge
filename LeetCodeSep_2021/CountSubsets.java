public class CountSubsets {


    public int dp(int[] nums, int target) {

        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {

                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    public int memoization(int[] nums, int target, int[][] memo, int index) {

        if (target == 0) {
            return 1;
        }

        if (target < 0 || index == nums.length) {
            return 0;
        }

        if (memo[index][target] != -1) {
            return memo[index][target];
        }

        memo[index][target] = memoization(nums, target, memo, index + 1) + memoization(nums, target - nums[index], memo, index + 1);
        return memo[index][target];
    }

    public int recursive(int[] nums, int target, int index) {

        if (target == 0) {
            return 1;
        }

        if (index == nums.length) {
            return 0;
        }

        if (nums[index] > target) {
            return recursive(nums, target, index + 1);
        }
        return recursive(nums, target, index + 1) + recursive(nums, target - nums[index], index + 1);
    }
}
