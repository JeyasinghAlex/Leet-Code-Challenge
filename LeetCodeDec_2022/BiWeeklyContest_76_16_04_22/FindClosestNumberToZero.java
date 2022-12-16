package BiWeeklyContest_76_16_04_22;

public class FindClosestNumberToZero {

    public int findClosestNumber(int[] nums) {

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            int abs = Math.abs(nums[i]);
            if (abs <= min) {
                min = abs;
                if (Math.abs(ans) == abs) {
                    ans = Math.max(ans, nums[i]);
                } else {
                    ans = nums[i];
                }
            }
        }
        return ans;
    }
}
