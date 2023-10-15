package Arrays;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {


            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int lo = i + 1;
            int hi = n - 1;

            while (lo < hi) {

                if (hi != n - 1 && nums[hi] == nums[hi + 1]) {
                    --hi;
                    continue;
                }
                long sum = (long) nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    ++lo;
                    --hi;
                }
                else if (sum < 0) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
