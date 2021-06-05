import java.util.HashMap;
import java.util.Map;

public class CombinationSum_IV {

    /* Using DP */

    public int usedDP(int[] nums, int target) {
        int[] count = new int[target + 1];
        count[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int num : nums) {
                if (i - num >= 0) {
                    count[i] += count[i - num];
                }
            }
        }
        return count[target];
    }

    /* Using Map  */
    private Map<Integer, Integer> map = new HashMap<>();
    public int usedMap(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0 || target < 0)
            return 0;
        if (target == 0)
            return 1;
        if (map.containsKey(target))
            return map.get(target);
        for (int i = 0; i < nums.length; ++i) {
            count += usedMap(nums, target - nums[i]);
        }
        map.put(target, count);
        return map.get(target);
    }

    /* Using Recursive :- Time Limit Exceeded  */
    public int usedRecursive(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (target >= nums[i]) {
                res += usedRecursive(nums, target - nums[i]);
            }
        }
        return res;
    }


    /* Memoization Approach :- Time Limit Exceeded  */
    public int usedMemoization(int[] nums, int[] memo, int target) {
        if (memo[target] != 0) {
            return memo[target];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (target >= nums[i]) {
                memo[target] += usedMemoization(nums, memo, target - nums[i]);
            }
        }
        return memo[target];
    }
}
