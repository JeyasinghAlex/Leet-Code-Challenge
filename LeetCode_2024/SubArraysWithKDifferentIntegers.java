package LeetCode_2024;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return countSubarray(nums, k) - countSubarray(nums, k - 1);
    }

    private int countSubarray(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int right = 0; right < n; ++right) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                ++left;
            }
            ans += (right - left + 1);
        }
        return ans;
    }
}
