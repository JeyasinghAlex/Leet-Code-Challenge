public class MinimumNumberOfDaysToDisconnectIsland {

    public int minDays(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int cnt = numberOfIsland(grid);
        if (cnt == 0 || cnt > 1) {
            return 0;
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    cnt = numberOfIsland(grid);
                    if (cnt == 0 || cnt > 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int numberOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ++count;
                    if (count > 1) {
                        return count;
                    }
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] visited) {

        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return ;
        }

        visited[r][c] = true;

        dfs(r + 1, c, grid, visited);
        dfs(r - 1, c, grid, visited);
        dfs(r, c + 1, grid, visited);
        dfs(r, c - 1, grid, visited);
    }
}
