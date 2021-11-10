import java.util.ArrayList;
import java.util.List;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {

        List<int[]> x = new ArrayList<>();
        List<int[]> y = new ArrayList<>();

        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {

                if (grid[i][j] == 1) {

                    ++count;

                    if (count == 1) {
                        dfs(grid, x, i, j);
                    }
                    else if (count == 2) {
                        dfs(grid, y, i, j);
                    } else {
                        break;
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < x.size(); ++i) {
            for (int j = 0; j < y.size(); ++j) {
                int[] a = x.get(i);
                int[] b = y.get(j);

                int dis = Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) - 1;
                min = Math.min(min, dis);
            }
        }
        return min;
    }

    private void dfs(int[][] grid, List<int[]> list, int r, int c) {

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return ;
        }

        grid[r][c] = 0;

        list.add(new int[]{r, c});

        dfs(grid, list, r, c + 1);
        dfs(grid, list, r, c - 1);
        dfs(grid, list, r + 1, c);
        dfs(grid, list, r - 1, c);
    }
}
