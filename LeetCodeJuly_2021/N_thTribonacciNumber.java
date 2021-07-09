public class N_thTribonacciNumber {


    public int tribonacci(int n) {

        if (n < 2) {
            return n;
        }
        int a = 0, b = 1, c = 1, d = 0;
        while (n-- > 2) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    public int tribonacci_1(int n) {

        int[] dp = new int[2 + n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
