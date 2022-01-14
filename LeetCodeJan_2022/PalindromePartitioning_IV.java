public class PalindromePartitioning_IV {

    public boolean checkPartitioning(String s) {

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
                int k = i + j;
                if (s.charAt(j) == s.charAt(k) && dp[j + 1][k - 1]) {
                    dp[j][k] = true;
                }
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {

                if (dp[0][i - 1] && dp[i][j - 1] && dp[j][n - 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
