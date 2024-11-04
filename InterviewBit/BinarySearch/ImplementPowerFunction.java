package InterviewBit.BinarySearch;

public class ImplementPowerFunction {

    public int pow(int x, int n, int d) {

        if (d == 1)
            return 0;

        if (x == 1 || n == 0)
            return 1;

        long ans = 1;
        long base = x % d;

        if (base < 0)
            base += d;

        while (n > 0) {
            if (n % 2 == 1) {
                ans = (ans * base) % d;
                --n;
            }
            else {
                base = (base * base) % d;
                n = n / 2;
            }
        }
        return (int) ans;
    }
}
