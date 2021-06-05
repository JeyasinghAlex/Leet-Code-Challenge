package LeetCodeMay_2021;

import java.util.Arrays;

public class JumpGame_II {

    public int jump(int[] nums) {

        int[] jump = new int[nums.length];
        Arrays.fill(jump, Integer.MAX_VALUE);
        jump[0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (i <= j + nums[j]) {
                    jump[i] = Math.min(jump[i], jump[j] + 1);
                }
            }
        }
        return jump[nums.length - 1];
    }
}
