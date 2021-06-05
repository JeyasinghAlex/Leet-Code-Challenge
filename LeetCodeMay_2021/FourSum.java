package LeetCodeMay_2021;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int lo = j + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        ++lo;
                        --hi;
                    } else if (sum < target) {
                        ++lo;
                    } else {
                        --hi;
                    }
                }
            }
        }
        return new ArrayList(set);
    }
}
