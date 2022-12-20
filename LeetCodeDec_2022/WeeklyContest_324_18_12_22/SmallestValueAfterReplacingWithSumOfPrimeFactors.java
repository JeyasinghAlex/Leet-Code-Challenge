package WeeklyContest_324_18_12_22;

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {

    public int smallestValue(int n) {

        int[] spf = new int[n + 1];
        sieve(spf, n);

        int num = n;
        int ans = Integer.MAX_VALUE;
        while (num > 1) {
            int temp = num;
            int sum = 0;
            while (temp > 1) {
                sum += spf[temp];
                temp = temp / spf[temp];
            }
            ans = Math.min(ans, sum);
            if (sum == num) break;
            num = sum;
        }
        return ans;
    }

    private void sieve(int[] spf, int n) {

        for (int i = 1; i <= n; ++i) {
            spf[i] = i;
        }

        for (int i = 2; i <= n; ++i) {
            if (spf[i] == i) {
                for (long j = (long) i * i; j <= n; j += i) {
                    if (spf[(int) j] == j) {
                        spf[(int) j] = i;
                    }
                }
            }
        }
    }
}
