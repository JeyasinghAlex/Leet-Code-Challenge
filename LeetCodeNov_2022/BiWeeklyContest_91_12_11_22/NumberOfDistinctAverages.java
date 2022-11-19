package BiWeeklyContest_91_12_11_22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages {

    public int distinctAverages(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n / 2; ++i) {
            set.add(nums[i] + nums[n - i - 1]);
        }
        return set.size();
    }
}
