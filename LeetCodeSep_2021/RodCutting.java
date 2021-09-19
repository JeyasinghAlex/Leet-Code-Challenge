public class RodCutting {

    public int rodCutting(int[] pieces, int[] profit, int length    ) {

        int n = pieces.length;
        int[][] dp = new int[n + 1][length + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= length; ++j) {

                if (j < pieces[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], profit[i - 1] + dp[i][j - pieces[i - 1]]);
                }
            }
        }
        return dp[n][length];
    }
}
