public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col;  ++j) {
                int len = dfs(i, j, matrix, dir, dp);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] dir, int[][] dp) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int max = 1;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(x, y, matrix, dir, dp);
                max = Math.max(max, len);
            }
        }
        dp[i][j] = max;
        return max;
    }
}
