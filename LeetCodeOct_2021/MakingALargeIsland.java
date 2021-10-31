public class MakingALargeIsland {

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 0}};
        System.out.println(new MakingALargeIsland().largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean flag = true;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    flag = false;
                    grid[i][j] = 1;
                    dfs(grid, visited, i, j);
                    grid[i][j] = 0;
                    count = 0;
                }
            }
        }
        if (flag) {
            return row * col;
        }
        return max;
    }

    int max = 0;
    int count = 0;
    private void dfs(int[][] grid, boolean[][] visited, int r, int c) {


        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return ;
        }

        visited[r][c] = true;
        max = Math.max(max, ++count);
        dfs(grid, visited, r, c + 1);
        dfs(grid, visited, r, c - 1);
        dfs(grid, visited, r + 1, c);
        dfs(grid, visited, r - 1, c);
        visited[r][c] = false;
    }
}
