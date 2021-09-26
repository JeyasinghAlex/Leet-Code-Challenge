import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(cnt, 1);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                    max = Math.max(max, dp[i]);
                    cnt[i] = cnt[j];
                } else if (dp[j] + 1 == dp[i]) {
                    cnt[i] += cnt[j];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (dp[i] == max) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
