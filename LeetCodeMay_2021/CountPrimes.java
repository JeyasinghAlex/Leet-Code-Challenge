package LeetCodeMay_2021;

import java.util.Arrays;

public class CountPrimes {

    //Sieve of eratosthenes
    public int countPrimes(int n) {

        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (arr[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    arr[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (arr[i]) {
                ++count;
            }
        }
        return count;
    }
}
