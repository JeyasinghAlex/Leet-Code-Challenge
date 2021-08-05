public class StoneGame {


    private int[][] dp;
    private int[] prefixSum;
    public boolean stoneGame(int[] arr) {

        int n = arr.length;
        prefixSum = new int[n];

        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        dp = new int[n][n];
        int alexGain = helper(arr, 0, n - 1);
        return alexGain > prefixSum[n - 1] - alexGain;
    }

    private int helper(int[] arr, int start, int end) {

        if (start > end) {
            return 0;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int sum = prefixSum[end] - prefixSum[start] + arr[start];
        int a = helper(arr, start + 1, end);
        int b = helper(arr, start, end - 1);
        dp[start][end] = sum - Math.min(a, b);
        return dp[start][end];
    }
}
