public class HouseRobber_II {

    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    private int rob(int[] nums, int start, int end) {

        int prev1 = 0;
        int prev2 = 0;
        for (int i = start; i < end; ++i) {
            int temp = prev1;
            prev1 = Math.max(nums[i] + prev2, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}
