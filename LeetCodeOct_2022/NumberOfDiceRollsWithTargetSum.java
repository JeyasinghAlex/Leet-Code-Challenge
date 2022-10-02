public class NumberOfDiceRollsWithTargetSum {

    private int MOD = 1000000007;
    private Integer[][] memo;
    public int numRollsToTarget(int n, int k, int target) {

        this.memo = new Integer[n + 1][target + 1];
        return memoization(n, k, target);
    }

    private int memoization(int n, int k, int target) {

        if (target == 0 && n == 0) {
            return 1;
        }

        if (target < 0 || n == 0) {
            return 0;
        }

        if (memo[n][target] != null) {
            return memo[n][target];
        }

        int ways = 0;
        for (int i = 1; i <= k; ++i) {
            ways = (ways + memoization(n - 1, k, target - i)) % MOD;
        }
        memo[n][target] = ways;
        return ways;
    }
}
