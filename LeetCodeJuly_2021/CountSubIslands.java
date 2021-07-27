public class CountSubIslands {


    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int count = 0;
        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[i].length; ++j) {

                if (grid2[i][j] == 1 && dfs(grid1, grid2, i, j)) {
                    ++count;
                }
            }
        }
        return count;
    }


    private boolean dfs(int[][] grid1, int[][] grid2, int r, int c) {

        if (r < 0 || r >= grid2.length || c < 0 || c >= grid2[0].length || grid2[r][c] == 0) {
            return true;
        }

        if (grid2[r][c] != grid1[r][c]) {
            return false;
        }

        grid2[r][c] = 0;
        boolean right = dfs(grid1, grid2, r, c + 1);
        boolean left = dfs(grid1, grid2, r, c - 1);
        boolean down = dfs(grid1, grid2, r + 1, c);
        boolean up = dfs(grid1, grid2, r - 1, c);
        return right && left && down && up;
    }
}
