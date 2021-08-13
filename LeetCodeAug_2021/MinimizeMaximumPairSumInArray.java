import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {

        int max = Integer.MIN_VALUE;
        int n = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; ++i) {
            max = Math.max(max, nums[i] + nums[n - i]);
        }
        return max;
    }
}
