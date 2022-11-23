package WeeklyContest_292_08_05_22;

public class Largest_3_SameDigitNumberInString {

    public String largestGoodInteger(String num) {

        int n = num.length();
        String ans = "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n - 3; ++i) {
            int val = num.charAt(i) - '0';
            if (val > max && num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                max = val;
                ans = num.substring(i, i + 3);
            }
        }
        return ans;
    }
}
