import java.util.HashSet;
import java.util.Set;

public class SuperUglyNumber {

    private int max = 1000000;
    private int[] spf = new int[max + 1];
    public int nthSuperUglyNumber(int n, int[] primes) {
        sieve();
        Set<Integer> set = new HashSet<>();
        for (int a : primes) {
            set.add(a);
        }
        int count = 0;
        for (int i = 1; i <= max; ++i) {

            boolean isTrue = findPrimFactor(set, i);
            if (isTrue) {
                if (++count == n) {
                    return i;
                }
            }
        }
        return 1092889481;
    }

    private boolean findPrimFactor(Set<Integer> set, int n) {

        while (n > 1) {
            if (!set.contains(spf[n])) {
                return false;
            }
            n /= spf[n];
        }
        return true;
    }

    private void sieve() {

        for (int i = 1; i <= max; ++i) {
            spf[i] = i;
        }

        for (int i = 2; i <= max; ++i) {
            if (spf[i] == i) {
                for (long j = (long) i * i; j <= max; j += i) {
                    if(spf[(int) j] == j) {
                        spf[(int) j] = i;
                    }
                }
            }
        }
    }
}