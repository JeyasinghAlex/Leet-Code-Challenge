public class PerfectSquares {

    public int numSquares_dp(int n) {

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

    public int numSquares_memo(int n) {

        int[] memo = new int[n + 1];
        return memoization(n, memo);
    }

    private int memoization(int n, int[] memo) {

        if (n <= 3) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int ans = n;
        for (int i = 1; i * i <= n; ++i) {
            int sq = i * i;
            ans = Math.min(ans, 1 + memoization(n - sq, memo));
        }
        memo[n] = ans;
        return ans;
    }
}
