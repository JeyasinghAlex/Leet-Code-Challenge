package BiWeeklyContest_84_06_08_22;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {

    public long countBadPairs(int[] nums) {

        //Invalid = Total- Valid
        // j - i != nums[j] - nums[i]
        // j - nums[j] = i - nums[i]

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        long goodPair = 0;
        long totalPair = (long) n * (n - 1) / 2;

        for (int i = 0; i < n; ++i) {
            int val = i - nums[i];
            goodPair += map.getOrDefault(val, 0);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        return totalPair - goodPair;
    }
}
