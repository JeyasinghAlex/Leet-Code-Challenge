public class ArrangingCoins {

    public int arrangeCoins(int n) {

        long lo = 0;
        long hi = n;

        while (lo <= hi) {

            long mid = lo + hi >>> 1;
            long temp = (mid * (mid + 1)) >>> 1;

            if (temp == n) {
                return (int) mid;
            } else if (n > temp) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) lo - 1;
    }

    public int arrangeCoins_1(int n) {
        if (n == 1) {
            return n;
        }
        int temp = n;
        for (int i = 1; i <= n; ++i) {
            temp -= i;
            if (temp < 0) {
                return i - 1;
            }
        }
        return -1;
    }
}
