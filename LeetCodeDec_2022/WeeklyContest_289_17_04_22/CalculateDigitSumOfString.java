package WeeklyContest_289_17_04_22;

public class CalculateDigitSumOfString {

    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder temp = new StringBuilder();
            int sum = 0;
            for (int i = 0; i < s.length(); ++i) {
                sum += s.charAt(i) - '0';
                if ((i + 1) % k == 0) {
                    temp.append(sum);
                    sum = 0;
                }
            }
            if (s.length() % k != 0) {
                temp.append(sum);
            }
            s = temp.toString();
        }
        return s;
    }
}
