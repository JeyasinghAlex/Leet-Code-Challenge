import java.util.LinkedList;
import java.util.Queue;

public class Matrix {

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> qu = new LinkedList<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {

                if (mat[i][j] == 0) {
                    qu.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!qu.isEmpty()) {
            int[] cell = qu.poll();
            for (int[] dir : direction) {

                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];
                if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] != -1) {
                    continue;
                }
                qu.offer(new int[]{r, c});
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }
        return mat;
    }
}
