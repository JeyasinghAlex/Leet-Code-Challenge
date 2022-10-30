package WeeklyContest_317_30_10_22;

public class MinimumAdditionToMakeIntegerBeautiful {

    public long makeIntegerBeautiful(long n, int target) {

        long ans = 0;
        long pow = 1L;

        while (sumDigit(n) > target) {
            long diff = 10 - (n % 10);
            ans = ans + (pow * diff);
            n = n / 10;
            ++n;// carry
            pow = pow * 10;
        }
        return ans;
    }

    private long sumDigit(long n) {

        long sum = 0L;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
