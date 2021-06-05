import java.util.Arrays;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1, ans = 0, max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] != nums[i - 1]) {
                if (++count == 3) {
                    return nums[i - 1];
                }
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
