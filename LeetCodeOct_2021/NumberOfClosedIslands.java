public class NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }

        if (grid[r][c] == 1) {
            return true;
        }

        grid[r][c] = 1;

        boolean l = dfs(grid, r, c + 1);
        boolean m = dfs(grid, r, c - 1);
        boolean a = dfs(grid, r + 1, c);
        boolean b = dfs(grid, r - 1, c);

        if (a && b && l && m) {
            return true;
        }
        return false;
    }


    boolean flag = true;
    public int closedIsland_1(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if (flag) {
                        ++count;
                    }
                    flag = true;
                }
            }
        }
        return count;
    }


    private void dfs_1(int[][] grid, int r, int c) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 0) {
            return ;
        }

        if (r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length - 1) {
            flag = false;
        }

        grid[r][c] = 2;

        dfs_1(grid, r, c + 1);
        dfs_1(grid, r, c - 1);
        dfs_1(grid, r + 1, c);
        dfs_1(grid, r - 1, c);

    }
}
