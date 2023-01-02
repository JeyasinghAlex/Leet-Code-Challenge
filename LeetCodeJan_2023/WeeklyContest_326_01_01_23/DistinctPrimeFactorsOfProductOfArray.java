package WeeklyContest_326_01_01_23;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeFactorsOfProductOfArray {

    public int distinctPrimeFactors(int[] nums) {

        int max = 1000;
        int[] spf = new int[max + 1];
        sieve(spf);

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int i = num;
            while (i != 1) {
                set.add(spf[i]);
                i /= spf[i];
            }
        }
        return set.size();
    }

    private void sieve(int[] spf) {

        int n = spf.length;
        for (int i = 1; i < n; ++i) {
            spf[i] = i;
        }

        for (int i = 2; i < n; ++i) {
            if (spf[i] == i) {
                for (long j = (long) i * i; j < n; j += i) {
                    if (spf[(int) j] == j) {
                        spf[(int) j] = i;
                    }
                }
            }
        }
    }
}
