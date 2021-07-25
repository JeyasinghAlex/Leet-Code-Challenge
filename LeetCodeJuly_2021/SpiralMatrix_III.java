public class SpiralMatrix_III {

    private int idx = 0;
    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {

        int[][] ans = new int[rows * cols][2];

        ans[idx++] = new int[]{r, c};
        int len = 0;
        while (idx < rows * cols) {

            ++len;
            for (int i = 0; i < len; ++i) add(rows, cols, r, ++c, ans);
            for (int i = 0; i < len; ++i) add(rows, cols, ++r, c, ans);
            ++len;
            for (int i = 0; i < len; ++i) add(rows, cols, r, --c, ans);
            for (int i = 0; i < len; ++i) add(rows, cols, --r, c, ans);

        }
        return ans;
    }

    private void add(int rows, int cols, int r, int c, int[][] ans) {

        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            ans[idx++] = new int[]{r, c};
        }
    }

    public int[][] spiralMatrixIII_1(int rows, int cols, int r, int c) {

        int[][] ans = new int[rows * cols][2];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        int len = 0;
        int d = 0;
        ans[idx++] = new int[]{r, c};
        while (idx < rows * cols) {

            if (d == 0 || d == 2) {
                ++len;
            }

            for (int i = 0; i < len; ++i) {
                r += dir[d][0];
                c += dir[d][1];

                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    ans[idx++] = new int[]{r, c};
                }
            }
            d = (d + 1) % 4;
        }
        return ans;
    }
}
