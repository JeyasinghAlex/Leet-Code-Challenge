package WeeklyContest_319_13_11_22;

public class MaximumNumberOfNonOverlappingPalindromeSubStrings {

    public int maxPalindromes(String s, int k) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
            }
        }

        for (int i = 2; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                int l = i + j;
                if (s.charAt(j) == s.charAt(i + j) && dp[j + 1][l - 1]) {
                    dp[j][l] = true;
                }
            }
        }
        Integer[] memo = new Integer[n];
        return maxPalindrome(0, k, dp, memo);
    }

    private int maxPalindrome(int start, int k, boolean[][] dp, Integer[] memo) {

        if (start == dp.length) {
            return 0;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        int ans = maxPalindrome(start + 1, k, dp, memo);

        for (int end = start + k - 1; end < dp.length; ++end) {
            if (dp[start][end]) {
                ans = Math.max(ans, 1 + maxPalindrome(end + 1, k, dp, memo));
            }
        }
        memo[start] = ans;
        return ans;
    }
}
