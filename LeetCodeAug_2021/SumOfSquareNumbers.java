public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {

        int i = 0;
        int j = (int) Math.sqrt(c);
        long a = 0;
        long b = 0;

        while (i <= j) {
            a = i * i;
            b = j * j;
            long mul = a + b;
            if (mul == c) {
                return true;
            }else if (mul > c) {
                --j;
            } else if (mul < c) {
                ++i;
            }
        }
        return false;
    }
}