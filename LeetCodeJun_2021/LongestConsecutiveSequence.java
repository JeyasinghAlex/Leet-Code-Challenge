package LeetCodeJun_2021;

import java.util.Arrays;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

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