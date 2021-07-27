import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean fr = false;
        boolean fc = false;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;

                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(fr) {
            for (int i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }

        if (fc) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes_1(int[][] matrix) {

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {

                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
