import java.util.EnumSet;

public class SubsetSum {

    public boolean dp(int[] nums, int target) {

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= target; ++j) {

                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    public boolean memoization(int[] nums, Boolean[][] memo, int target, int index) {

        if (target == 0) {
            return true;
        }

        if (target < 0 || index == nums.length) {
            return false;
        }

         if (memo[index][target] != null) {
            return memo[index][target];
        }
         return memoization(nums, memo, target, index + 1) || memoization(nums, memo, target - nums[index], index + 1);
    }

    public boolean recursion(int[] nums, int target, int index) {

        if (target == 0) {
            return true;
        }

        if (index == nums.length) {
            return false;
        }

        if (nums[index] > target) {
            return recursion(nums, target, index + 1);
        }

        return recursion(nums, target, index + 1) || recursion(nums, target - nums[index], index + 1);
    }
}
