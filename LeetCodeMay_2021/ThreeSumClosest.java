package LeetCodeMay_2021;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE - target;
        for (int i = 0; i < nums.length; ++i) {

            int lo = i + 1; int hi = nums.length - 1;
            while (lo < hi) {

                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }

                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return ans;
    }
}
