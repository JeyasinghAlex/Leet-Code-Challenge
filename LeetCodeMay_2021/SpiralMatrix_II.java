public class SpiralMatrix_II {

    public int[][] generateMatrixOptimized(int n) {

        int[][] res = new int[n][n];
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        int d = 0;
        int cnt = 1;
        while (cnt <= n * n) {

            res[row][col] = cnt++;
            int r = Math.floorMod(row + dir[d][0], n);
            int c = Math.floorMod(col + dir[d][1],  n);

            if (res[r][c] != 0) {
                d = (d + 1) % 4;
            }

            row += dir[d][0];
            col += dir[d][1];
        }

        return res;
    }

    public static int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0,top = 0;
        int right = n -1,down = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j ++) {
                ret[top][j] = count++;
            }
            top ++;
            for (int i = top; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            for (int j = right; j >= left; j --) {
                ret[down][j] = count ++;
            }
            down --;
            for (int i = down; i >= top; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }

    public int[][] generateMatrix_1(int n) {

        int[][] matrix = new int[n][n];
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        int num = 1;
        while (startRow <= endRow && startCol <= endCol) {

            for (int i = startCol; i <= endCol; ++i) {
                matrix[startRow][i] = num++;
            }
            startRow++;
            for (int i = startRow; i <= endRow; ++i) {
                matrix[i][endCol] = num++;
            }
            endCol--;
            if (startRow <= endRow && startCol <= endCol) {

                for (int i = endCol; i >= startCol; --i) {
                    matrix[endRow][i] = num++;
                }
                endRow--;
                for (int i = endRow; i >= startRow; --i) {
                    matrix[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return matrix;
    }
}
