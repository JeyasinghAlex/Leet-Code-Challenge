package WeeklyContest_326_01_01_23;

public class ClosestPrimeNumbersInRange {

    public int[] closestPrimes(int left, int right) {

        int max = (int) 1e6;
        int[] spf = new int[max + 1];
        sieve(spf);
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int num1 = -1;
        int num2 = -1;
        int min = Integer.MAX_VALUE;

        for (int i = left; i <= right; ++i) {

            if (spf[i] == i && i != 1) {
                num2 = num1;
                num1 = i;

                int diff = num1 - num2;
                if (num1 != -1 && num2 != -1 && diff < min) {
                    ans[0] = num2;
                    ans[1] = num1;
                    min = diff;
                }
            }
        }
        return ans;
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
