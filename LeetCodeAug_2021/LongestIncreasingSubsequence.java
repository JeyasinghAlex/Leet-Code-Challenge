import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; ++i) {
            int index = lowerBond(dp, nums[i]);
            dp[index] = nums[i];
        }
        return lowerBond(dp, Integer.MAX_VALUE);
    }

    private int lowerBond(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int lengthOfLIS_1(int[] nums) {

        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        int max = 1;
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
//                if (nums[i] > nums[j] && lis[i] <= lis[j]) {
//                    lis[i] = 1 + lis[j];
//                }
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    max = Math.max(max, lis[i]);
                }
            }
        }
        return max;
    }
}
