package WeeklyContest_309_4_09_22;

public class NumberOfWaysToReachPositionAfterExactly_K_Steps {

    private final int MOD = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(endPos - startPos) > k) {
            return 0;
        }
        Integer[][] dp = new Integer[5001][1001];
        return dfs(startPos, endPos, k, dp);
    }

    private int dfs(int st, int ed, int step, Integer[][] dp) {

        if (step == 0) {
            if (st == ed) {
                return 1;
            }
            return 0;
        }

        if (dp[st + 1000][step] != null) {
            return dp[st + 1000][step];
        }

        int left = dfs(st - 1, ed, step - 1, dp) % MOD;
        int right = dfs(st + 1, ed, step - 1, dp) % MOD;

        dp[st + 1000][step] = (left + right) % MOD;
        return dp[st + 1000][step];
    }
}
