package weekly_24_7_22;

public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) {

        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][0] == grid[0][j]) {
                    boolean flag = isEqual(i, j, grid);
                    if (flag) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    private boolean isEqual(int r, int c, int[][] grid) {

        for (int i = 0; i < grid.length; ++i) {
            if (grid[r][i] != grid[i][c]) {
                return false;
            }
        }
        return true;
    }
}
