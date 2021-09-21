public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        int max = 1;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < n - i + 1; ++j) {

                int k = i + j - 1;
                if (i == 2 && s.charAt(j) == s.charAt(k)) {
                    dp[j][k] = 2;
                } else if (s.charAt(j) ==  s.charAt(k)) {
                    dp[j][k] = 2 + dp[j + 1][k - 1];
                } else {
                    dp[j][k] = Math.max(dp[j][k - 1], dp[j + 1][k]);
                }
                max = Math.max(max, dp[j][k]);
            }
        }
        return max;
    }

    private int memoization(String s, int l, int r, int[][] memo) {

        if (l == r) {
            return 1;
        }

        if (l > r) {
            return 0;
        }

        if (memo[l][r] != 0) {
            return memo[l][r];
        }

        if (s.charAt(l) == s.charAt(r)) {
            return 2 + memoization(s, l + 1, r - 1, memo);
        }
        memo[l][r] = Math.max(memoization(s, l + 1, r, memo), memoization(s, l, r - 1, memo));
        return memo[l][r];
    }

    private int recursive(String s, int l, int r) {

        if (l == r) {
            return 1;
        }
        if (l > r) {
            return 0;
        }

        if (s.charAt(l) == s.charAt(r)) {
            return 2 + recursive(s, l + 1, r - 1);
        }

        return Math.max(recursive(s, l + 1, r), recursive(s, l, r - 1));
    }
}
