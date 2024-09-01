package InterviewBit;

public class PowerfulDivisors {

    public int[] powerfulDivisors(int[] A) {

        int n = A.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            max = Math.max(max, A[i]);
        }

        int[] divisors = new int[max + 1];
        int[] counts = new int[max + 1];

        for (int i = 1; i <= max; ++i) {
            for (int j = 1; i * j <= max; ++j) {
                divisors[i * j]++;
            }
        }

        for (int i = 1; i <= max; ++i) {
            if (isPowerOfTwo(divisors[i])) {
                counts[i] = (i > 0 ? counts[i - 1] : 0) + 1;
            } else {
                counts[i] = (i > 0 ? counts[i - 1] : 0);
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = counts[A[i]];
        }
        return res;
    }

    private boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        return (n & (n - 1)) == 0;
    }
}
