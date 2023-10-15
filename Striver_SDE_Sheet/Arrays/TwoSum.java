package Arrays;

import java.util.HashMap;
import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};

            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public int[] twoSum_1(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target)
                return new int[]{left, right};
            else if (sum < target)
                ++left;
            else
                --right;
        }
        return new int[]{};
    }
}
