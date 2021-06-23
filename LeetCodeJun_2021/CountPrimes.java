import java.util.Arrays;

public class CountPrimes {

    public int countPrimes(int n) {

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (prime[i]) {
                for (int j = i << 1; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (prime[i]) {
                ++count;
            }
        }
        return count;
    }

    public int countPrimes_1(int n) {

        int[] prime = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            prime[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(n); ++i) {

            if (prime[i] == i) {
                for (int j = i << 1; j <= n; j += i) {
                    prime[j] = i;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (prime[i] == i) {
                ++count;
            }
        }
        return count;
    }
}
