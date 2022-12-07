package BiWeeklyContest_77_30_04_22;

import java.util.LinkedList;
import java.util.Queue;

public class CountUnguardedCellsInTheGrid {

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        char[][] grid = new char[m][n];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> qu = new LinkedList<>();

        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];

            grid[r][c] = 'G';
            qu.offer(new int[]{r, c});
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }


        while (!qu.isEmpty()) {
            int[] arr = qu.poll();
            int r = arr[0];
            int c = arr[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                while (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 'W' && grid[nr][nc] != 'G') {
                    grid[nr][nc] = 'P';
                    nr += d[0];
                    nc += d[1];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] != 'G' && grid[i][j] != 'W' && grid[i][j] != 'G' && grid[i][j] != 'P') {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
