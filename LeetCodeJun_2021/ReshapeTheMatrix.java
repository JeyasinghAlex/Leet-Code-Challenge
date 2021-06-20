public class ReshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length;
        int col = mat[0].length;

        if (r * c != row * col) {
            return mat;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i  < row; ++i) {
            for (int j = 0; j < col; ++j) {
                res[count / c][count % c] = mat[i][j];
                ++count;
            }
        }
        return res;
    }
}
