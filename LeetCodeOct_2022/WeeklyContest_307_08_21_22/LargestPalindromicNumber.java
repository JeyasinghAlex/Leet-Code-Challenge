package WeeklyContest_307_08_21_22;

public class LargestPalindromicNumber {

    public String largestPalindromic(String num) {

        int[] freq = new int[10];

        for (char ch : num.toCharArray()) {
            freq[ch - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; --i) {

            if (i == 0 && sb.length() == 0)
                break;

            while (freq[i] > 1) {
                sb.append(i);
                freq[i] -= 2;
            }
        }
        String mid = "";
        for (int i = 9; i >= 0; --i) {
            if (freq[i] > 0) {
                mid += i;
                break;
            }
        }
        String ans = sb.toString() + mid + sb.reverse().toString();
        return ans;
    }
}
