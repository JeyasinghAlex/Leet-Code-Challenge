public class MaximumSumCircularSubArray {

    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum1 = 0;
        int sum2 = 0;
        int total = 0;

        for (int i = 0; i < n; ++i) {
            sum1 += nums[i];
            sum2 += nums[i];
            total += nums[i];
            if (sum1 < min) {
                min = sum1;
            }

            if (sum1 > 0) {
                sum1 = 0;
            }

            if (sum2 > max) {
                max = sum2;
            }

            if (sum2 < 0) {
                sum2 = 0;
            }
        }

        if (total == min) {
            return max;
        }
        return Math.max(max, total - min);
    }
}
