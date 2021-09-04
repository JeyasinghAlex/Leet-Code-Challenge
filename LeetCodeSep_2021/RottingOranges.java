import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> qu = new LinkedList<>();
        int zero = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 0) {
                    ++zero;
                }
                if (grid[i][j] == 2) {
                    qu.offer(new int[]{i, j});
                }
            }
        }
        if (zero == row * col) {
            return 0;
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        while (!qu.isEmpty()) {

            int len = qu.size();
            boolean flag = true;

            while (len-- > 0) {

                int[] cell = qu.poll();

                for (int[] d : dir) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] == 0) {
                        continue;
                    }

                    if (grid[r][c] == 1) {
                        grid[r][c] = 2;
                        qu.offer(new int[]{r, c});
                        if (flag) {
                            flag = false;
                            ++count;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }
}
