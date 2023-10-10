package DynamicProgramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        recursion(text1, text2, 0, 0);
        memo(text1, text2, 0, 0, dp);
        dp(text1, text2);

        return 0;

    }

    private int recursion(String text1, String text2, int idx1, int idx2) {

        if (idx1 == text1.length() || idx2 == text2.length())
            return 0;

        if (text1.charAt(idx1) == text2.charAt(idx2))
            return 1 + recursion(text1, text2, idx1 + 1, idx2 + 1);

        return Math.max(recursion(text1, text2, idx1 + 1, idx2),
                recursion(text1, text2, idx1, idx2 + 1));
    }

    private int memo(String text1, String text2, int idx1, int idx2, int[][] dp) {

        if (idx1 == text1.length() || idx2 == text2.length())
            return 0;

        if (dp[idx1][idx2] != 0)
            return dp[idx1][idx2];

        if (text1.charAt(idx1) == text2.charAt(idx2))
            return dp[idx1][idx2] = 1 + memo(text1, text2, idx1 + 1, idx2 + 1, dp);

        return dp[idx1][idx2] = Math.max(memo(text1, text2, idx1 + 1, idx2, dp),
                memo(text1, text2, idx1, idx2 + 1, dp));
    }

    private int dp(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
