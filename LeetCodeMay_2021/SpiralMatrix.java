package LeetCodeMay_2021;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int startRow = 0;
        int endRow = row - 1;
        int startCol = 0;
        int endCol = col - 1;

        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; ++i) {
                list.add(matrix[startRow][i]);
            }
            ++startRow;
            for (int i = startRow; i <= endRow; ++i) {
                list.add(matrix[i][endCol]);
            }
            --endCol;
            if (startRow <= endRow && startCol <= endCol) {

                for (int i = endCol; i >= startCol; --i) {
                    list.add(matrix[endRow][i]);
                }
                --endRow;
                for (int i = endRow; i >= startRow; --i) {
                    list.add(matrix[i][startCol]);
                }
                ++startCol;
            }
        }
        return list;
    }
}
