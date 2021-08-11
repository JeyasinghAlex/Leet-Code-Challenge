import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
            return -1;
        }
        int level = 0;
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        Queue<int[]> qu = new LinkedList<>();
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        qu.offer(new int[]{0, 0});
        while (!qu.isEmpty()) {
            int len = qu.size();
            while (len-- > 0) {
                int[] temp = qu.poll();
                if (temp[0] == row - 1 && temp[1] == col - 1) {
                    return ++level;
                }
                for (int[] point : dir) {
                    int r = point[0] + temp[0];
                    int c = point[1] + temp[1];

                    if (r >= 0 && r < row && c >= 0 && c < col && !visited[r][c] && grid[r][c] == 0) {
                        qu.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            ++level;
        }
        return -1;
    }
}
