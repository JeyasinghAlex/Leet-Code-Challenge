public class CountDifferentPalindromicSubSequences {

    public int countPalindromicSubsequences(String s) {

        int n = s.length();
        int mod = 1_000_000_007;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                int k = i + j;
                if (s.charAt(j) != s.charAt(k)) {
                    dp[j][k] = dp[j][k - 1] + dp[j + 1][k] - dp[j + 1][k - 1];
                } else {
                    dp[j][k] = dp[j + 1][k - 1] * 2;
                    int low = j + 1;
                    int high = k - 1;

                    while (low <= high && s.charAt(low) != s.charAt(k)) {
                        ++low;
                    }
                    while (low <= high && s.charAt(high) != s.charAt(k)) {
                        --high;
                    }

                    if (low > high) {
                        dp[j][k] += 2;
                    } else if (low == high) {
                        dp[j][k] += 1;
                    } else {
                        dp[j][k] -= dp[low + 1][high - 1];
                    }
                }
                dp[j][k] = dp[j][k] < 0 ? dp[j][k] + mod : dp[j][k] % mod;
            }
        }
        return dp[0][n - 1];
    }
}
