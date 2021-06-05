public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if(j == col - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    int ans = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                    matrix[i][j] += Math.min(ans, matrix[i - 1][j + 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int a : matrix[row - 1]) {
            min = Math.min(min, a);
        }

        return min;
    }
}
