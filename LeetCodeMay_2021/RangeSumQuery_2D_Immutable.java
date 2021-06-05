package LeetCodeMay_2021;

public class RangeSumQuery_2D_Immutable {

//    Approach #4 (Caching Smarter) [Accepted]
    private final int[][] dp;
    public RangeSumQuery_2D_Immutable(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        this.dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; ++i) {
            for (int j = 1; j <= col; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }


    //    private final int[][] matrix;

    /*public RangeSumQuery_2D_Immutable(int[][] matrix) {
        this.matrix = matrix;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; ++i) {
            for (int j = col1; j <= col2; ++j) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }*/
}
