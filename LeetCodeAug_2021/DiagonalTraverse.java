public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {

        int r = 0;
        int c = 0;
        int row = mat.length;
        int col = mat[0].length;
        int[] ans = new int[row * col];

        for (int i = 0; i < ans.length; ++i) {
            ans[i] = mat[r][c];

            if ((r + c) % 2 == 0) {

                if (c == col - 1) {
                    ++r;
                } else if (r == 0) {
                    ++c;
                } else {
                    --r;
                    ++c;
                }
            } else {

                if (r == row - 1) {
                    ++c;
                } else if (c == 0) {
                    ++r;
                } else {
                    ++r;
                    --c;
                }
            }
        }
        return ans;
    }
}
