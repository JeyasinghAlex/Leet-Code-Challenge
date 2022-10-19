package BiWeeklyContest_86_3_9_22;

import java.util.HashSet;
import java.util.Set;

public class FindSubArraysWithEqualSum {

    public boolean findSubarrays(int[] nums) {

        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < n; ++i) {
            set.add(nums[i - 1] + nums[i]);
        }

        return set.size() != n - 1;
    }

    public boolean findSubarrays_1(int[] nums) {

        int n = nums.length;

        if (n <= 2) {
            return false;
        }

        for (int i = 1; i < n; ++i) {
            int sum1 = nums[i] + nums[i - 1];
            for (int j = i + 1; j < n; ++j) {
                int sum2 = nums[j] + nums[j - 1];
                if (sum1 == sum2) {
                    return true;
                }
            }
        }
        return false;
    }
}
