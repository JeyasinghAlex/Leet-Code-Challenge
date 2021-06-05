package LeetCodeMay_2021;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int ro = matrix.length;
        int co = matrix[0].length;
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();

        for (int i = 0; i < ro; ++i) {
            for (int j = 0; j < co; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < ro; ++i) {
            for (int j = 0; j < co; ++j) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
