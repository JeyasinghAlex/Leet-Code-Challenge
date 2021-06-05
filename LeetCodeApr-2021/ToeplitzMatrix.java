import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {



//    Approach #1: Group by Category [Accepted]
    public boolean isToeplitzMatrixGroup(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (!map.containsKey(i - j)) {
                    map.put(i - j, matrix[i][j]);
                } else if (map.get(i - j) != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

//    Approach #2: Compare With Top-Left Neighbor [Accepted]
    public boolean isToeplitzMatrixCompareWithTopLeft(int[][] matrix) {
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i - 1][j - 1] != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
//    Own Approach:
    public boolean isToeplitzMatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < col; ++i) {
            int r = 0, c = i;
            int val = matrix[r][c];
            while (r < row -1 && c < col - 1) {

                if (matrix[++r][++c] != val) {
                    return false;
                }
            }
        }

        for (int i = 1; i < row; ++i) {
            int r = i, c = 0;
            int val = matrix[r][c];
            while (r < row - 1 && c < col - 1) {
                if (matrix[++r][++c] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}
