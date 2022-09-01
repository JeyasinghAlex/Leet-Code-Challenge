import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i = 0; i < row; ++i) {
            dfs(i, 0, i, 0, heights, pacific);
            dfs(i, col - 1, i, col - 1, heights, atlantic);
        }

        for (int i = 0; i < col; ++i) {
            dfs(0, i, 0, i, heights, pacific);
            dfs(row - 1, i, row - 1, i, heights, atlantic);
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }


    private void dfs(int r, int c, int lr, int lc, int[][] heights, boolean[][] visited) {

        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c] || heights[r][c] < heights[lr][lc]) {
            return ;
        }

        visited[r][c] = true;

        dfs(r + 1, c, r, c, heights, visited);
        dfs(r - 1, c, r, c, heights, visited);
        dfs(r, c + 1, r, c, heights, visited);
        dfs(r, c - 1, r, c, heights, visited);

    }

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic_1(int[][] heights) {

        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> list = new ArrayList<>();

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        for (int i = 0; i < col; ++i) {
            dfs(heights, pacific, 0, i, Integer.MIN_VALUE);
            dfs(heights, atlantic, row - 1, i, Integer.MIN_VALUE);
        }

        for (int i = 0; i < row; ++i) {
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i, col - 1, Integer.MIN_VALUE);
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }
        return list;
    }


    private void dfs(int[][] hights, boolean[][] visited, int r, int c, int prev) {

        if (r < 0 || r >= hights.length || c < 0 || c >= hights[0].length || visited[r][c] || prev > hights[r][c]) {
            return ;
        }

        visited[r][c] = true;
        for (int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];
            dfs(hights, visited, x, y, hights[r][c]);
        }
    }
}
