public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (target > sum || ((sum + target) & 1) == 1) {
            return 0;
        }

        target = Math.abs(sum + target) >>> 1;

        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <=  n; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}
