public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum >>> 1;
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

    public boolean canPartition_1(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }

        if ((sum & 1) == 1 || nums.length == 1) return false;

        int half = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][half + 1];
        return helper(nums, 0, half, memo);

    }

    private boolean helper(int[] nums, int index, int target, Boolean[][] memo) {

        if (target == 0) {
            return true;
        }

        if (nums.length == index || target < 0) {
            return false;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        memo[index][target] = helper(nums, index + 1, target, memo) || helper(nums, index + 1, target - nums[index], memo);
        return memo[index][target];

    }
}
