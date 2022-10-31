package WeeklyContest_302_17_07_22;

import java.util.*;

public class MinimumDeletionsToMakeArrayDivisible {

    public int minOperations(int[] nums, int[] numsDivide) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; ++i) {
            gcd = gcd(gcd, numsDivide[i]);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (gcd % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public int minOperations_1(int[] nums, int[] numsDivide) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> tset = new TreeSet<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            tset.add(num);
        }

        int gcd = numsDivide[0];
        for (int i = 1; i < numsDivide.length; ++i) {
            gcd = gcd(gcd, numsDivide[i]);
        }

        int ans = 0;
        for (int num : tset) {
            if (gcd % num == 0) {
                return ans;
            } else {
                ans += map.get(num);
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
