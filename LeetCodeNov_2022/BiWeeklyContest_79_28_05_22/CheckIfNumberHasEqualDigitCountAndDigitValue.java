package BiWeeklyContest_79_28_05_22;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {

    public boolean digitCount(String num) {

        int[] freq = new int[10];
        for (char ch : num.toCharArray()) {
            freq[ch - '0']++;
        }

        for (int i = 0; i < num.length(); ++i) {
            int cnt = num.charAt(i) - '0';
            if (freq[i] != cnt) {
                return false;
            }
        }
        return true;
    }
}
