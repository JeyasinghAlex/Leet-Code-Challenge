package WeeklyContest_291_01_05_22;

public class RemoveDigitFromNumberToMaximizeResult {

    public String removeDigit(String number, char digit) {

        int n = number.length();
        String ans = "";
        for (int i = 0; i < n; ++i) {
            if (number.charAt(i) == digit) {
                String num = number.substring(0, i) + number.substring(i + 1);
                if (num.compareTo(ans) > 0) {
                    ans = num;
                }
            }
        }
        return ans;
    }
}
