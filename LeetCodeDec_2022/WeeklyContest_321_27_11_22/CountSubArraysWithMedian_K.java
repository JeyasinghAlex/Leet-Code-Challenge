package WeeklyContest_321_27_11_22;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraysWithMedian_K {

    public int countSubarrays(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int idxK = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == k) {
                idxK = i;
                break;
            }
        }

        int sum = 0;
        for (int i = idxK + 1; i < n; ++i) {
            sum += nums[i] > k ? 1 : -1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        sum = 0;
        int ans = map.getOrDefault(0, 0) + map.getOrDefault(1, 0);
        for (int i = idxK - 1; i >= 0; --i) {
            sum += nums[i] > k ? 1 : -1;
            ans += map.getOrDefault(-sum, 0) + map.getOrDefault((1 - sum), 0);
        }
        return ans;
    }
}
