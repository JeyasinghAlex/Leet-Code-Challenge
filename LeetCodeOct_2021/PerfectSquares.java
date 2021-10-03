public class PerfectSquares {

    public int numSquares(int n) {

        if (n <= 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; ++i) {
            dp[i] = i;
            for (int j = 1; j * j <= i; ++j) {
                int sq = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - sq]);
            }
        }
        return dp[n];
    }
}
