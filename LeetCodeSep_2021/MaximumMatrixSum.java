public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {

        long count = 0;
        long min = Long.MAX_VALUE;
        long ans = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {

                if (matrix[i][j] < 0) {
                    ++count;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
                ans += Math.abs(matrix[i][j]);
            }
        }
        return count % 2 == 0 ? ans : ans - (2 * min);
    }
}
