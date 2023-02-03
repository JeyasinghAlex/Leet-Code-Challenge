package BiWeeklyContest_96_21_01_23;

public class CheckIfPointIsReachable {

    public boolean isReachable(int targetX, int targetY) {

        int val = gcd(targetX, targetY);
        return isPowerOfTwo(val);
    }

    private boolean  isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
