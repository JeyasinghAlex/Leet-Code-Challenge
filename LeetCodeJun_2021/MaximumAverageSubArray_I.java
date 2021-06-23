public class MaximumAverageSubArray_I {

    public double findMaxAverage(int[] nums, int k) {


        int left = 0;
        double max = Integer.MIN_VALUE;
        int prev = 0;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = nums[i] + nums[i - 1];
        }

        for (int i = k - 1; i < nums.length; ++i) {

            int sum = nums[i] - prev;
            max = Math.max(max, sum);
            prev = nums[left++];
        }
        return max / k;
    }
}
