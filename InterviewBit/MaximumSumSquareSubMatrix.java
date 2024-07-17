package InterviewBit;

public class MaximumSumSquareSubMatrix {

    public int solve(int[][] A, int B) {

        int n = A.length;
        int[][] prefSum = new int[n + 1][n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                prefSum[i][j] = prefSum[i - 1][j] + prefSum[i][j - 1] - prefSum[i - 1][j - 1] + A[i - 1][j - 1];
            }
        }

        for (int i = B; i <= n; ++i) {
            for (int j = B; j <= n; ++j) {
                int sum = prefSum[i][j] - prefSum[i - B][j] - prefSum[i][j - B] + prefSum[i - B][j - B];
                max = Math.max(max, sum);
            }
        }
        return max;

    }
}
