package LeetCodeMay_2021;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements_II {


    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        int median = nums[mid];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += Math.abs(nums[i] - median);
        }
        return sum;
    }

    public static int minMoves2(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int sum = 0;
        while (i < j) {
            sum += Math.abs(nums[i++] - nums[j--]);
        }
        return sum;
    }
}
