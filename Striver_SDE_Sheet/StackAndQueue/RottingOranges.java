package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int ans = 0;
        int zero = 0;

        Queue<int[]> qu = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0) {
                    ++zero;
                }
                if (grid[i][j] == 2) {
                    qu.offer(new int[]{i, j});
                }
            }
        }

        if (zero == grid.length * grid[0].length)
            return 0;

        while (!qu.isEmpty()) {
            int len = qu.size();
            boolean isRottan = false;
            while (len-- > 0) {

                int[] temp = qu.poll();

                for (int[] d : dir) {

                    int x = temp[0] + d[0];
                    int y = temp[1] + d[1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        qu.offer(new int[]{x, y});
                        isRottan = true;
                    }
                }
            }
            if (isRottan)
                ++ans;
        }

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
