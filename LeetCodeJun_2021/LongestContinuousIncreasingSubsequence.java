public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; ++i) {

            if (nums[i] > nums[i - 1]) {
                ++count;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return Math.max(max, count);
    }
}
