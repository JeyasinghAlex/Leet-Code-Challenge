package WeeklyContest_315_16_10_22;

public class SumOfNumberAndItsReverse {

    public boolean sumOfNumberAndReverse(int num) {

        for (int i = 0; i <= 100000; ++i) {

            int reverseNum = reverse(i);

            int sum = i + reverseNum;
            if (sum == num) {
                return true;
            }
        }
        return false;
    }

    private int reverse(int num) {

        int n = 0;

        while (num > 0) {
            int rem = num % 10;
            n = n * 10 + rem;
            num = num / 10;
        }
        return n;
    }
}
