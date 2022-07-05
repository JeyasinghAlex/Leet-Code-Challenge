
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 1;
        int ans = 0;
        for (int num : nums) {

            int prev = num - 1;
            int next = num + 1;

            while (set.contains(prev)) {
                ++max;
                set.remove(prev--);
            }

            while (set.contains(next)) {
                ++max;
                set.remove(next++);
            }

            ans = Math.max(max, ans);
            max = 1;

        }
        return ans;
    }

    public int longestConsecutive_1(int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);

        int index = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (i < 2 || nums[i - 1] < nums[i]) {
                nums[index++] = nums[i];
            }
        }

        int count = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < index; ++i) {
            if (nums[i] - nums[i - 1] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}