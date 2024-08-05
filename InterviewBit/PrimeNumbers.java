package InterviewBit;

public class PrimeNumbers {

    public int[] sieve(int A) {

        int[] prime = new int[A + 1];
        for (int i = 0; i <= A; ++i) {
            prime[i] = i;
        }

        for (int i = 2; i <= A; ++i) {
            for (int j = i << 1; j <= A; j += i) {
                if (prime[i] == i) {
                    prime[j] = i;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i <= A; ++i) {
            if (prime[i] == i)
                ++cnt;
        }

        int[] ans = new int[cnt];
        int idx = 0;
        for (int i = 2; i <= A; ++i) {
            if (prime[i] == i)
                ans[idx++] = i;
        }
        return ans;
    }
}
