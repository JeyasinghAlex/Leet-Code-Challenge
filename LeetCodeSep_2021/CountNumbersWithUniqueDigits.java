public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }

        int uniqueNumber = 9;
        int availableNumber = 9;
        int res = 10;
        while (n-- > 1 && availableNumber > 0) {

            uniqueNumber = uniqueNumber * availableNumber;
            res += uniqueNumber;
            availableNumber--;
        }
        return res;
    }
}
