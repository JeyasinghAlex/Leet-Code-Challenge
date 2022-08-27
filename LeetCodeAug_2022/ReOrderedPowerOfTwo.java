public class ReOrderedPowerOfTwo {

    public boolean reorderedPowerOf2(int n) {

        int[] base = count(n);

        for (int i = 0; i < 31; ++i) {

            int[] temp = count(1 << i);

            if (check(base, temp)) {
                return true;
            }
        }
        return false;
    }

    private int[] count(int n) {

        int[] count = new int[10];

        while (n > 0) {

            int rem = n % 10;
            n = n / 10;
            count[rem]++;

        }
        return count;
    }

    public boolean reorderedPowerOf2_1(int n) {

        int limit = 1000000000;

        int[] digit = new int[10];
        splitDigit(n, digit);

        int power = 1;

        while (power < limit) {

            int[] temp = new int[10];

            splitDigit(power, temp);

            if (check(digit, temp)) {
                return true;
            }
            power = power * 2;

        }
        return false;
    }

    private boolean check(int[] a, int[] b) {
        for (int i = 0; i < 10; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private void splitDigit(int n, int[] digit) {

        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            digit[rem]++;

        }
    }
}
