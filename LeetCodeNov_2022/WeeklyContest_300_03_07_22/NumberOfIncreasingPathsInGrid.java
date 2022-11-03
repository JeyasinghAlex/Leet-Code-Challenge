package WeeklyContest_300_03_07_22;

public class NumberOfIncreasingPathsInGrid {

    int mod = 1000000007;
    public int countPaths(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        long[][] dp = new long[row][col];
        long ans = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                ans = (ans + dfs(grid, dp, i, j, 0) % mod) % mod;
            }
        }
        return (int) ans;
    }

    private long dfs(int[][] grid, long[][] dp, int r, int c, int prev) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= prev) {
            return 0;
        }

        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        long down = dfs(grid, dp, r + 1, c, grid[r][c]);
        long up = dfs(grid, dp, r - 1, c, grid[r][c]);
        long right = dfs(grid, dp, r, c + 1, grid[r][c]);
        long left = dfs(grid, dp, r, c - 1, grid[r][c]);
        dp[r][c] = (1 + down + up + right + left) % mod;
        return dp[r][c];
    }
}
