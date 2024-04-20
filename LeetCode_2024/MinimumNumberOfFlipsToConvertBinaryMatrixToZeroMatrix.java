package LeetCode_2024;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {

    public int minFlips(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;
        boolean[][] visited = new boolean[row][col];

        int ans = helper(mat, visited);

        if (ans == Integer.MAX_VALUE - 1) {
            return -1;
        }
        return ans;
    }

    private int helper(int[][] mat, boolean[][] visited) {

        int row = mat.length;
        int col = mat[0].length;
        int ans = Integer.MAX_VALUE - 1;

        if (isAllZero(mat)) {
            return 0;
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {

                if (!visited[i][j]) {
                    visited[i][j] = true;
                    flip(i, j, mat);
                    int curr = 1 + helper(mat, visited);
                    flip(i, j, mat);
                    visited[i][j] = false;
                    ans = Math.min(ans, curr);
                }
            }
        }
        return ans;
    }

    private void flip(int r, int c, int[][] mat) {

        mat[r][c] = 1 - mat[r][c];

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];

            if (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) {
                mat[x][y] = 1 - mat[x][y];
            }
        }
    }

    private boolean isAllZero(int[][] mat) {

        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
