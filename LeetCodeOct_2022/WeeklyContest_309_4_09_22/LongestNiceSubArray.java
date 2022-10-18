package WeeklyContest_309_4_09_22;

public class LongestNiceSubArray {

    public int longestNiceSubarray(int[] nums) {

        int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; ++i) {
            int curr = nums[i];
            for (int j = i + 1; j < n; ++j) {
                if ((curr & nums[j]) != 0) {
                    break;
                }
                curr = curr | nums[j];
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
