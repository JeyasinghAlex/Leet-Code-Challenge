package weekly_25_4_21;

public class SumOfDigitsBaseK {

    public int sumBase(int n, int k) {
        int rem = 0;
        while (n > 0) {
            rem += n % k;
            n = n / k;
        }
        return rem;
    }
}
