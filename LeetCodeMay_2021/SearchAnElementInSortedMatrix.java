package LeetCodeMay_2021;

public class SearchAnElementInSortedMatrix {

    public static boolean binarySearch2DMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int row = 0;
        int col = n - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                ++row;
            }
        }
        return false;
    }
}
