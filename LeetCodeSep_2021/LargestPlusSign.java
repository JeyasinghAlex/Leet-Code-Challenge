import java.util.Arrays;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = buildGrid(n, mines);
        int[][] r = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    sum = 0;
                } else {
                    sum += grid[i][j];
                }
                r[i][j] = sum;
            }
        }

        int[][] l = new int[n][n];
        for (int i = 0; i < n; ++i) {
            sum = 0;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 0) {
                    sum = 0;
                } else {
                    sum += grid[i][j];
                }
                l[i][j] = sum;
            }
        }

        int[][] t = new int[n][n];
        for (int i = 0; i < n; ++i) {
            sum = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[j][i] == 0) {
                    sum = 0;
                } else {
                    sum += grid[j][i];
                }
                t[j][i] = sum;
            }
        }

        int[][] b = new int[n][n];
        for (int i = 0; i < n; ++i) {
            sum = 0;
            for (int j = n - 1; j >= 0; --j) {
                if (grid[j][i] == 0) {
                    sum = 0;
                } else {
                    sum += grid[j][i];
                }
                b[j][i] = sum;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int x = Math.min(l[i][j], r[i][j]);
                int y = Math.min(t[i][j], b[i][j]);
                int z = Math.min(x, y);
                ans = Math.max(ans, z);
            }
        }
        return ans;
    }

    private int[][] buildGrid(int n, int[][] mines) {

        int[][] inputGrid = new int[n][n];
        for (int[] grid : inputGrid) {
            Arrays.fill(grid, 1);
        }

        for (int[] mine : mines) {
            int i = mine[0];
            int j = mine[1];
            inputGrid[i][j] = 0;
        }
        return inputGrid;
    }
}
