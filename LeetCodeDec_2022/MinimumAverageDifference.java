public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {

        int n = nums.length;
        long sum = 0;
        long left = 0;
        long right = 0;
        long min = Long.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];
        }

        for (int i = 0; i < n; ++i) {
            left += nums[i];
            right = sum - left;
            long a = left / (i + 1);
            long b = (i == n - 1) ? 0 : right / (n - i - 1);
            long diff = Math.abs(a - b);
            if (diff < min) {
                min = diff;
                ans = i;
            }
        }
        return ans;
    }

    public int minimumAverageDifference_1(int[] nums) {

        int n = nums.length;
        long[] preSum = new long[n];
        preSum[0] = nums[0];

        for (int i  = 1; i < n; ++i) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        long totalSum = preSum[n - 1];
        int ans = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            long a = preSum[i] / (i + 1);
            long b = (n - i - 1) == 0 ? 0 : (totalSum - preSum[i]) / (n - i - 1);

            long diff = Math.abs(a - b);
            if (diff < min) {
                min = diff;
                ans = i;
            }
        }
        return ans;
    }
}
