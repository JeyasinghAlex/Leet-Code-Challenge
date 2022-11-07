package WeeklyContest_318_06_11_22;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubArraysWithLength_K {

    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        if (n < k) {
            return 0;
        }

        long sum = 0L;
        long max = 0;

        Set<Integer> set = new HashSet<>();
        int left = 0;
        for (int i = 0; i < n; ++i) {

            while (set.contains(nums[i])) {
                set.remove(nums[left]);
                sum -= nums[left++];
            }

            set.add(nums[i]);
            sum += nums[i];


            if (set.size() == k) {
                max = Math.max(max, sum);
                set.remove(nums[left]);
                sum -= nums[left++];
            }
        }
        return max;
    }
}
