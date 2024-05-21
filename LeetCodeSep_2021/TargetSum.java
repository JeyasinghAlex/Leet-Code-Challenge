public class TargetSum {


    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }

        return memo(0, 0, target, nums);
    }

    private int memo(int index, int sum, int target, int[] nums) {

        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        
        int pos = memo(index + 1, sum + nums[index], target, nums);
        int neg = memo(index + 1, sum - nums[index], target, nums);
        return pos + neg;
    }

    
    public int findTargetSumWays(int[] nums, int target) {
        
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }

        Integer[][] dp = new Integer[n + 1][sum + 1001];

        return memo(0, 0, target, nums, dp);
    }

    private int memo(int index, int sum, int target, int[] nums, Integer[][] dp) {

        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        if (dp[index][sum + 1000] != null) {
            return dp[index][sum + 1000];
        }
        int pos = memo(index + 1, sum + nums[index], target, nums, dp);
        int neg = memo(index + 1, sum - nums[index], target, nums, dp);
        dp[index][sum + 1000] = pos + neg;
        return dp[index][sum + 1000];
    }

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
