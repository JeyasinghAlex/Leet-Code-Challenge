package WeeklyContest_332_12_02_23;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {

    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        int n = nums.length;
        int lo = n - 1;
        int hi = n - 1;

        long ans = 0l;
        for (int i = 0; i < n; ++i) {

            while (0 <= hi && nums[i] + nums[hi] > upper)
                --hi;

            while (0 <= lo && nums[i] + nums[lo] >= lower)
                --lo;

            ans += hi - lo;

            if (i > lo && i <= hi)
                --ans;
        }
        return ans / 2;
    }
}
