package Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        return countPath(0, 0, m, n);
    }

    private int countPath(int r, int c, int m, int n) {

        if (r == m - 1 && c == n - 1)
            return 1;
        else if (r >= m || c >= n)
            return 0;

        return countPath(r + 1, c, m, n) + countPath(r, c + 1, m, n);
    }

    public int uniquePaths_1(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
