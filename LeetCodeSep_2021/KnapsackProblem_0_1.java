public class KnapsackProblem_0_1 {

    public int dp(int[] weight, int[] profit, int w) {

        int n = weight.length;

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= weight.length; ++i) {
            for (int j = 1; j <= w; ++j) {
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }

    public int memoization(int[] weight, int[] profit, int[][] memo, int n, int w) {

        if (w == 0 || n == 0) {
            return 0;
        }
        if (memo[n][w] != -1) {
            return memo[n][w];
        }

        if (weight[n - 1] > w) {
            return memoization(weight, profit, memo, n - 1, w);
        } else {
            int findNext = memoization(weight, profit, memo, n - 1, w);
            int include = profit[n - 1] + memoization(weight, profit, memo, n - 1, w - weight[n - 1]);
            memo[n][w] = Math.max(findNext, include);
        }
        return memo[n][w];
    }

    public int recursive(int[] weight, int[] profit, int n, int w) {

        if (w == 0 || n == 0) {
            return 0;
        } else if (weight[n - 1] > w) {
            return recursive(weight, profit, n - 1, w);
        } else {
            int findNext = recursive(weight, profit, n - 1, w);
            int include = profit[n - 1] + recursive(weight, profit, n - 1, w - weight[n - 1]);
            return Math.max(findNext, include);
        }
    }
}
