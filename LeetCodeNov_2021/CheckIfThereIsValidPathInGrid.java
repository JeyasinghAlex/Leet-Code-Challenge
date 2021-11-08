import java.util.HashMap;
import java.util.Map;

public class CheckIfThereIsValidPathInGrid {

    private static Map<Integer, int[][]> map = new HashMap<>();
    static {
        map.put(1, new int[][]{{0, 1}, {0, -1}});
        map.put(2, new int[][]{{1, 0}, {-1, 0}});
        map.put(3, new int[][]{{0, -1}, {1, 0}});
        map.put(4, new int[][]{{0, 1}, {1, 0}});
        map.put(5, new int[][]{{-1, 0}, {0, -1}});
        map.put(6, new int[][]{{-1, 0}, {0, 1}});
    }

    public boolean hasValidPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        return dfs(grid, visited, 0, 0);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int r, int c) {


        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return true;
        }

        visited[r][c] = true;

        int street = grid[r][c];
        for (int[] arr : map.get(street)) {
            int x = r + arr[0];
            int y = c + arr[1];

            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
                continue;
            }

            street = grid[x][y];
            for (int[] back : map.get(street)) {

                int nextX = x + back[0];
                int nextY = y + back[1];
                if (nextX == r && nextY == c) {
                    if (dfs(grid, visited, x, y)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
