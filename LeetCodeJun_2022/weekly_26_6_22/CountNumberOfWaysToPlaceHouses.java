package weekly_26_6_22;

public class CountNumberOfWaysToPlaceHouses {

    public int countHousePlacements(int n) {
        long mod = 1000000007;
        long ans = 0;
        long last = 1;
        long prevLast = 1;
        for (int i = 1; i <= n; ++i) {
            ans = (last + prevLast) % mod;
            prevLast = last;
            last = ans;
        }
        return (int) ((ans % mod * ans % mod) % mod);
    }
}
