public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {

                if (matrix[i - 1][j - 1] == '1') {

                    min = Math.min(dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
