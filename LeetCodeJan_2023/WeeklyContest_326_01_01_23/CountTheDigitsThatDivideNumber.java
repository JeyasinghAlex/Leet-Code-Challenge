package WeeklyContest_326_01_01_23;

public class CountTheDigitsThatDivideNumber {

    public int countDigits(int num) {

        int temp = num;
        int ans = 0;

        while (temp > 0) {
            int rem = temp % 10;
            if (num % rem == 0) {
                ++ans;
            }
            temp /= 10;
        }
        return ans;
    }
}
