package LeetCodeMay_2021;

import java.util.*;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            set.add(a);
        }

        int max = 0;
        for (int a : set) {
            if (!set.contains(a - 1)) {
                int m = a + 1;
                while (set.contains(m)) {
                    ++m;
                }
                max = Math.max(max, m - a);
            }
        }
        return max;
    }
}
