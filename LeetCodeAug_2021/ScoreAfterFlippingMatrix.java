public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; ++i) {
            if (grid[i][0] == 0) {
                flipRow(grid[i]);
            }
        }

        for (int i = 1; i < col; ++i) {
            int one = setColCount(grid, i);
            int zero = grid.length - one;

            if (one < zero) {
                flipCol(grid, i);
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != 0) {
                    ans += 1 << (col - j - 1);
                }
            }
        }
        return ans;
    }

    private void flipCol(int[][] grid, int c) {
        for (int i = 0; i < grid.length; ++i) {
            grid[i][c] = grid[i][c] ^ 1;
        }
    }

    private int setColCount(int[][] grid, int c) {
        int sum = 0;
        for (int i = 0; i < grid.length; ++i) {
            sum += grid[i][c];
        }
        return sum;
    }

    private void flipRow(int[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = arr[i] ^ 1;
        }
    }
}
