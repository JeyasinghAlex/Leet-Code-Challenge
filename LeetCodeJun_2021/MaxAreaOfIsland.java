package LeetCodeJun_2021;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited);
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }
        return max;
    }

    private int count = 0;
    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
            return;
        }

        if (grid[row][col] == 1) {
            ++count;
        }

        visited[row][col] = true;
        dfs(row + 1, col, grid, visited);
        dfs(row - 1, col, grid, visited);
        dfs(row, col + 1, grid, visited);
        dfs(row, col - 1, grid, visited);
    }
}
