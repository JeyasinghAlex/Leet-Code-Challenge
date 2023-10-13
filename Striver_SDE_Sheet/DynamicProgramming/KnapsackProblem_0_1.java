package DynamicProgramming;

public class KnapsackProblem_0_1 {

    public int recursive(int idx, int[] weight, int[] profit, int n, int w) {

        if (idx == n || w <= 0)
            return 0;

        if (weight[idx] > w)
            return recursive(idx + 1, weight, profit, n, w);

        int include = profit[idx] + recursive(idx + 1, weight, profit, n, w - weight[idx]);
        int notInclude = recursive(idx + 1, weight, profit, n, w);

        return Math.max(include, notInclude);
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
}