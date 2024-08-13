package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimeSum {

    public int[] primesum(int A) {

        int[] prime = new int[A + 1];
        sieve(prime);

        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= A; ++i) {
            if (prime[i] == i)
                list.add(i);
        }

        for (int i = 0; i < list.size(); ++i) {
            int prime1 = list.get(i);
            int prime2 = A - prime1;

            int index = Collections.binarySearch(list, prime2);
            if (index >= 0)
                return new int[]{prime1, prime2};
        }
        return null;
    }

    private void sieve(int[] prime) {

        int n = prime.length;
        for (int i = 0; i < n; ++i)
            prime[i] = i;

        for (int i = 2; i < n; ++i) {
            for (int j = i << 1; j < n; j += i) {
                if (prime[j] == j)
                    prime[j] = i;
            }
        }
    }
}
