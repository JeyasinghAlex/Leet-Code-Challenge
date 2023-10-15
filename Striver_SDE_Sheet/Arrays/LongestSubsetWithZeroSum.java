package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsetWithZeroSum {

    public int LongestSubsetWithZeroSum(int[] nums) {

        int n = nums.length;
        int max = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            if (sum == 0) {
                max = i + 1;
            } else if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                max = Math.max(max, i - map.get(sum));
            }
        }
        return max;
    }
}
