package BiWeeklyContest_91_12_11_22;

public class CountWaysToBuildGoodStrings {

    private final int MOD = (int) 1e9 + 7;
    public int countGoodStrings(int low, int high, int zero, int one) {

        Integer[] memo = new Integer[high + 1];
        int ans = 0;
        for (int i = low; i <= high; ++i) {
            ans = (ans + memoization(i, zero, one, memo)) % MOD;
        }
        return ans;
    }

    private int memoization(int len, int zero, int one, Integer[] memo) {

        if (len == 0) {
            return 1;
        }
        if (len < 0) {
            return 0;
        }

        if (memo[len] != null) {
            return memo[len];
        }

        memo[len] = (memoization(len - zero, zero, one, memo) + memoization(len - one, zero, one, memo)) % MOD;
        return memo[len];
    }
}
