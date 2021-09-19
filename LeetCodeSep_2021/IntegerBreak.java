public class IntegerBreak {

    public int integerBreak(int n) {

        if(n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i < j) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], j * dp[i - j][j]);
                }
            }
        }
        return dp[n][n];
    }
}
