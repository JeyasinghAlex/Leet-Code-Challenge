public class IntegerReplacement {

    public int integerReplacement(int n) {

        int count = 0;
        while (n % 2 == 0) {
            n = n / 2;
            ++count;
        }

        if (n == 1) {
            return count;
        }

        if (n == Integer.MAX_VALUE) {
            return count + integerReplacement(n - 1);
        }
        return count + Math.min(integerReplacement(n - 1) + 1, integerReplacement(n + 1) + 1);
    }
}
