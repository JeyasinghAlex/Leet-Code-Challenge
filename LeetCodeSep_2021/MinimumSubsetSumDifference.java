public class MinimumSubsetSumDifference {

    public int solve(int[] nums) {

        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum; ++j) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        int len = sum / 2;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= len; ++i) {
            if (dp[n][i]) {
                min = Math.min(min, sum - (2 * i));
            }
        }
        return min;
    }
}
