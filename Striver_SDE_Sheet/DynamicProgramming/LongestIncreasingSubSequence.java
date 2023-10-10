package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, Integer.MAX_VALUE);

        for (int i = 0; i < n; ++i) {
            int idx = lowerBond(nums[i], lis);
            if (idx < n)
                lis[idx] = nums[i];
        }

        return lowerBond(Integer.MAX_VALUE, lis);
    }

    private int lowerBond(int target, int[] nums) {

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

        int n = nums.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
