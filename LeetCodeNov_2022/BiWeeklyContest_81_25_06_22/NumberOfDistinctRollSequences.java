package BiWeeklyContest_81_25_06_22;

public class NumberOfDistinctRollSequences {

    private int mod = (int) 1e9 + 7;
    public int distinctSequences(int n) {

        Integer[][][] memo = new Integer[n][7][7];
        return memoization(0, 0, 0, memo, n);
    }

    private int memoization(int index, int prev1, int prev2, Integer[][][] memo, int n) {


        if (index == n) {
            return 1;
        }

        if (memo[index][prev1][prev2] != null) {
            return memo[index][prev1][prev2];
        }

        int ans = 0;
        for (int curr = 1; curr <= 6; ++curr) {
            if (curr != prev1 && curr != prev2 && (prev1 == 0 || gcd(curr, prev1) == 1)) {
                ans = (ans + memoization(index + 1, curr, prev1, memo, n)) % mod;
            }
        }
        memo[index][prev1][prev2] = ans;
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
