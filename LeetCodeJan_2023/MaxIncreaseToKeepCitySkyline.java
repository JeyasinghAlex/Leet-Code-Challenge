public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int n = grid.length;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int val = getValue(i, j, grid);
                ans += val - grid[i][j];
            }
        }
        return ans;
    }


    private int getValue(int r, int c, int[][] grid) {

        int n = grid.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < n; ++i) {
            maxRow = Math.max(maxRow, grid[r][i]);
        }

        for (int i = 0; i < n; ++i) {
            maxCol = Math.max(maxCol, grid[i][c]);
        }

        return Math.min(maxRow, maxCol);
    }
}
