package Arrays;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

    public void setZeroes(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        boolean fr = false;
        boolean fc = false;

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        fr = true;
                    if (j == 0)
                        fc = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < r; ++i) {
            for (int j = 1; j < c; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (fr) {
            for (int i = 0; i < c; ++i)
                matrix[0][i] = 0;
        }

        if (fc) {
            for (int i = 0; i < r; ++i)
                matrix[i][0] = 0;
        }
    }

    public void setZeroes_1(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (row.contains(i) || col.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}
