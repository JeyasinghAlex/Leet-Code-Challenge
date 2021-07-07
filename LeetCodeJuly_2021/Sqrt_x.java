public class Sqrt_x {

    public int mySqrt(int x) {

        long l = 0;
        long r = x;
        long res = 0;
        while (l <= r) {
            long mid = l + r >>> 1;

            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) res;
    }
}
