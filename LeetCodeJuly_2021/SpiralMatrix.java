import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        int dir = 0;
        List<Integer> list = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {

            if (dir == 0) {
                for (int i = startCol; i <= endCol; ++i)  list.add(matrix[startRow][i]);
                ++startRow;
            } else if (dir == 1) {
                for (int i = startRow; i <= endRow; ++i) list.add(matrix[i][endCol]);
                --endCol;
            } else if (dir == 2) {
                for (int i = endCol; i >= startCol; --i) list.add(matrix[endRow][i]);
                --endRow;
            } else if (dir == 3) {
                for (int i = endRow; i >= startRow; --i) list.add(matrix[i][startCol]);
                ++startCol;
            }
            dir = (dir + 1) % 4;
        }
        return list;
    }

    public List<Integer> spiralOrder_1(int[][] matrix) {

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
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