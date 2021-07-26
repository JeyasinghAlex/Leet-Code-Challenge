public class UniquePaths_III {

    public int uniquePathsIII(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int zero = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    ++zero;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        return dfs(grid, x, y, zero, -1);
    }

    private int dfs(int[][] grid, int x, int y, int zero, int count) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) {
            return 0;
        }

        if (grid[x][y] == 2) {
            return count == zero ? 1 : 0;
        }

        grid[x][y] = -1;
        int total = dfs(grid, x, y + 1, zero,  count + 1) +
                dfs(grid, x, y - 1, zero, count + 1) +
                dfs(grid, x + 1, y, zero, count + 1) +
                dfs(grid, x - 1, y, zero, count + 1);
        grid[x][y] = 0;
        return total;
    }
}