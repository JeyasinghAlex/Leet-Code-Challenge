public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int count = 0;
        for (int base = 5 ; n / base > 0; base *= 5) {
            count += n / base;
        }
        return count;
    }

    public int trailingZeroes_1(int n) {

        int base = 5;
        int count = 0;
        while (n / base != 0) {
            count += n / base;
            base = base * 5;
        }
        return count;
    }
}
