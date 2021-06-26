public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {

        int n = mat.length;
        int count = 0;
        while (count < 4) {
            if (compare(mat, target)) {
                return true;
            }
            for (int i = 0; i < n / 2; ++i) {
                for (int j = i; j < n - i - 1; ++j) {

                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }
            ++count;
        }
        return false;
    }

    private boolean compare(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
