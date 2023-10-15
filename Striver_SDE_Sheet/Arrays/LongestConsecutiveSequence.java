package Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if (n <= 1)
            return n;

        Set<Integer> set = new HashSet<>();
        int max = 1;

        for (int i = 0; i < n; ++i)
            set.add(nums[i]);

        for (int i = 0; i < n; ++i) {
            int prev = nums[i] - 1;
            int next = nums[i] + 1;

            int cnt = 1;
            set.remove(nums[i]);

            while (set.contains(prev)) {
                ++cnt;
                set.remove(prev--);
            }
            while (set.contains(next)) {
                ++cnt;
                set.remove(next++);
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
