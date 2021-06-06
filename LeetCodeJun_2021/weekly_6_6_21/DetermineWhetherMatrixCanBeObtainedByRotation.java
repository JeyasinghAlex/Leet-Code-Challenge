package LeetCodeJun_2021.weekly_6_6_21;

public class DetermineWhetherMatrixCanBeObtainedByRotation {

    public boolean findRotation(int[][] mat, int[][] target) {

        int rotate = 1;
        int n = mat.length;

        if (isEqual(mat, target)) {
            return true;
        }

        while (rotate++ <= 3) {

            for (int i = 0; i < n / 2; ++i) {
                for (int j = i; j < n - i - 1; ++j) {

                    int temp = mat[i][j];
                    mat[i][j] = mat[n - 1 - j][i];
                    mat[n - 1 - j][i] = mat[n - 1 - i][n - 1 - j];
                    mat[n - 1 - i][n - 1 - j] = mat[j][n - 1 - i];
                    mat[j][n - 1 - i] = temp;
                }
            }
            if (isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqual(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < target.length; ++j) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
