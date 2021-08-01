public class HouseRobber {

    public int rob(int[] nums) {

        int prev1 = 0;
        int prev2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            int temp = prev1;
            prev1 = Math.max(nums[i] + prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    public int rob_1(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = dp[0];
        if (nums.length > 1) {
            max = Math.max(max, nums[1]);
            dp[1] = max;
        }
        for (int i = 2; i < nums.length; ++i) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i -1]);
        }
        return dp[nums.length - 1];
    }
}
