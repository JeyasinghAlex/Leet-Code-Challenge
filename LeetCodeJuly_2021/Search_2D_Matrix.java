public class Search_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int lo = 0;
        int col = matrix[0].length;
        int hi = matrix.length * col - 1;

        while (lo < hi) {

            int mid = lo + hi >>> 1;

            if  (target > matrix[mid / col][mid % col]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return matrix[hi / col][hi % col] == target;
    }

    public boolean searchMatrix_1(int[][] matrix, int target) {

        int row = matrix.length - 1;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;

        while (i <= row && j >= 0) {

            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }
}
