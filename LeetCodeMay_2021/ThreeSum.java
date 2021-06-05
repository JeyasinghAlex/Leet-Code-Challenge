package LeetCodeMay_2021;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            int lo = i + 1;
            int hi = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    ++lo;
                    --hi;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        ++lo;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        --hi;
                    }
                } else if (sum < 0) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return res;
    }
}
