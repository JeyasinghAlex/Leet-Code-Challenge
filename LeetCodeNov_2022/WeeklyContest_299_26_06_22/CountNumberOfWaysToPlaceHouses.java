package WeeklyContest_299_26_06_22;

public class CountNumberOfWaysToPlaceHouses {

    public int countHousePlacementsUsingDB(int n) {

        long mod = 1000000007;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; ++i) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return (int) ((dp[n] % mod) * (dp[n] % mod) % mod);
    }

    public int countHousePlacementsUsingFibonacciSeries(int n) {

        long mod = 1000000007;

        long curr = 1;
        long prev = 1;
        long ans = 0;

        for (int i = 1; i <= n; ++i) {

            ans = (curr + prev) % mod;
            prev = curr;
            curr = ans;
        }
        return (int) ((ans % mod) * (ans % mod) % mod);
    }
}
