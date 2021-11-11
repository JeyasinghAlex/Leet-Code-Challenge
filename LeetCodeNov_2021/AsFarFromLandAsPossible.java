import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

    public int maxDistance(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> qu = new LinkedList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    qu.offer(new int[]{i, j});
                }
            }
        }

        int res = -1;
        while (!qu.isEmpty()) {

            int size = qu.size();
            while (size-- > 0) {

                int[] curr = qu.poll();
                res = Math.max(res, grid[curr[0]][curr[1]] - 1);

                for (int[] d : dir) {

                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];

                    if (x < 0 || x >= r || y < 0 || y >= c || visited[x][y]) {
                        continue;
                    }

                    visited[x][y] = true;
                    grid[x][y] = grid[curr[0]][curr[1]] + 1;
                    qu.offer(new int[]{x, y});
                }
            }
        }
        return res == 0 ? -1 : res;
    }
}
