package WeeklyContest_306_28_8_22;

public class LargestLocalValuesInAMatrix {

    public int[][] largestLocal(int[][] grid) {

        int n = grid.length;
        int size = n - 2;

        int[][] ans = new int[size][size];

        for (int i = 0; i < n - 2; ++i) {
            for (int j = 0; j < n - 2; ++j) {
                int max = getMax(i, j, i + 3, j + 3, grid);
                ans[i][j] = max;
            }
        }
        return ans;
    }

    private int getMax(int sr, int sc, int er, int ec, int[][] grid) {

        int max = Integer.MIN_VALUE;
        for (int i = sr; i < er; ++i) {
            for (int j = sc; j < ec; ++j) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
