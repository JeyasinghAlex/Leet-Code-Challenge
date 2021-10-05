public class RotateFunction {

    public int maxRotateFunction(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;
        int f0 = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            f0 += (i * nums[i]);
        }

        dp[0] = f0;
        int max = f0;
        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + sum - (n * nums[n - i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxRotateFunction_1(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int f = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            f += (i * nums[i]);
        }
        int max = f;
        for (int i = 1; i < n; ++i) {
            f = f + sum - (n * nums[n - i]);
            max = Math.max(max, f);
        }
        return max;
    }
}