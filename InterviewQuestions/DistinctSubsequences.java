package InterviewQuestions;

/**
 * Find number of times a string occurs as a subsequence in given string:
 *
 * Given two string, find the number of times the second string occurs in the first string,
 * Whether continuous or discontinuous
 */

/**
 * Salesforce:
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
