package WeeklyContest_328_15_01_23;

import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubArrays {

    public long countGood(int[] nums, int k) {

        int n = nums.length;
        long ans = 0;
        long curr = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i < nums.length; i++) {
            curr += map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (curr >= k) {
                map.put(nums[j], map.get(nums[j]) - 1);
                curr -= map.get(nums[j]);
                ++j;
            }
            ans += j;
        }
        return ans;
    }
}
