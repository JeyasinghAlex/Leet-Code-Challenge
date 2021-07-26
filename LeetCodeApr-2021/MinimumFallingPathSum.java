public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if(j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]);
                } else {
                    int ans = Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                    matrix[i][j] += Math.min(ans, matrix[i - 1][j + 1]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int a : matrix[n - 1]) {
            min = Math.min(min, a);
        }

        return min;
    }
}
