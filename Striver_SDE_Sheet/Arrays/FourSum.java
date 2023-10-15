package Arrays;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; ++i) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; ++j) {

                int lo = j + 1;
                int hi = n - 1;
                while (lo < hi) {

                    if (hi < n - 1 && nums[hi] == nums[hi + 1]) {
                        --hi;
                        continue;
                    }
                    long sum = (long) nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        ++lo;
                        --hi;
                    }
                    else if (target > sum)
                        ++lo;
                    else
                        --hi;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
