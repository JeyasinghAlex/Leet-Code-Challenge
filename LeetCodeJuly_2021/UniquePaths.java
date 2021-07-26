public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths_1(int m, int n) {

        int[][] memo = new int[m][n];
        return memoization(m - 1, n - 1, memo);
    }

    private int memoization(int m, int n, int[][] memo) {

        if (m < 0 || n < 0) {
            return 0;
        }
        else if (m == 0 || n == 0) {
            return 1;
        }
        else if (memo[m][n] != 0) {
            return memo[m][n];
        } else {
            memo[m][n] = memoization(m - 1, n, memo) + memoization(m, n - 1, memo);
            return memo[m][n];
        }
    }
}
