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
}
