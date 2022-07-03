package weekly_3_7_22;

public class NumberOfPeopleAwareOfaSecret {

    public int peopleAwareOfSecret(int n, int delay, int forget) {

        int mod = 1000000007;
        int[] nw = new int[n + 1];
        for (int i = 0; i <= n; i++) nw[i] = 0;
        nw[0] = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + delay; j <= n && j < i + forget; j++)
                nw[j] = (nw[j] + nw[i]) % mod;
            if (i + forget >= n)
                ans = (ans + nw[i]) % mod;
        }
        return ans;
    }
}
