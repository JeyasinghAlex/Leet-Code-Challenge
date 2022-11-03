package WeeklyContest_300_03_07_22;

public class NumberOfPeopleAwareOfSecret {

    public int peopleAwareOfSecret(int n, int delay, int forget) {

        int mod = 1000000007;
        int[] nw = new int[n + 1];

        nw[1] = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + delay; j <= n && j < i + forget; j++)
                nw[j] = (nw[j] + nw[i]) % mod;

        }

        for (int i = Math.max(0, n - forget + 1); i <= n; ++i) {
            ans = (ans + nw[i]) % mod;
        }
        return ans;
    }
}
