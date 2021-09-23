public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }
        int max = 0;
        int count = 0;
        int ans = 0;

        for (int j = 0; j <= nums.length - 3; ++j) {
            if (nums[j] - nums[j + 1] == nums[j + 1] - nums[j + 2]) {
                count = count + 1;
                ans += count;
                max = Math.max(max, ans);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
