package WeeklyContest_25_09_22;

public class LongestSubArrayWithMaximumBitwiseAND {

    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int ans = 1;
        int cnt = 0;

        for (int i = 0; i < n; ++i) {
            max = Math.max(max, nums[i]);
        }

        for (int i = 0; i < n; ++i) {

            if (nums[i] == max) {
                ++cnt;
            } else {
                cnt = 0;
            }

            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
