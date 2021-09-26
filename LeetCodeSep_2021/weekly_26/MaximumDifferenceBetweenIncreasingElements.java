package weekly_26;

public class MaximumDifferenceBetweenIncreasingElements {


    public int maximumDifference(int[] nums) {

        int max = -1;
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, nums[i] - nums[j]);
                }
            }
        }
        return max;
    }
}
