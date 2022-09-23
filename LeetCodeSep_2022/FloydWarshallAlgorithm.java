public class FloydWarshallAlgorithm {

    public void shortestDistance(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int k = 0; k < row; ++k) {
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (matrix[i][k] == -1 || matrix[k][j] == -1) {
                        continue;
                    }
                    int distance = matrix[i][k] + matrix[k][j];
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = distance;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], distance);
                }
            }
        }
    }
}
