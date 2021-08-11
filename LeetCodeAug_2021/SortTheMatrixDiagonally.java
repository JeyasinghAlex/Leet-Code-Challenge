import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).offer(mat[i][j]);
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        return mat;
    }

    public int[][] diagonalSort_1(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        for (int i = 0; i < row; ++i) {

            for (int j = 1; j < row; ++j) {

                for (int k = 1; k < col; ++k) {

                    if (mat[j - 1][k - 1] > mat[j][k]) {
                        int temp = mat[j][k];
                        mat[j][k] = mat[j - 1][k - 1];
                        mat[j - 1][k - 1] = temp;
                    }
                }
            }
        }
        return mat;
    }
}