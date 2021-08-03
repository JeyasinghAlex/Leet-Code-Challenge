import java.util.Arrays;

public class KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];

        while (lo < hi) {

            int mid = lo + hi >>> 1;
            int count = countLessNumber(matrix, mid);

            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int countLessNumber(int[][] matrix, int val) {

        int n = matrix.length;
        int j = n - 1;
        int count = 0;
        int i = 0;
        while (i < n && j >= 0) {

            if (matrix[i][j] > val) {
                --j;
            } else {
                count += j + 1;
                ++i;
            }
        }
        return count;
    }

    public int kthSmallest_1(int[][] matrix, int k) {

        int n = matrix.length;
        int[] temp = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                temp[idx++] = matrix[i][j];
            }
        }

        Arrays.sort(temp);
        return temp[k - 1];
    }
}
