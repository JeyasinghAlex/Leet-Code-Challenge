public class DetectCyclesIn2DGrid {

    public boolean containsCycle(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, dir, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int[][] dir, int i, int j, int lr, int lc) {

        visited[i][j] = true;

        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];

            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[i][j] != grid[r][c] || (r == lr && c == lc)) {
                continue;
            }

            if (visited[r][c]) {
                return true;
            }

            boolean flag = dfs(grid, visited, dir, r, c, i, j);
            if (flag) {
                return true;
            }
        }
        return false;
    }
}