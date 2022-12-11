package BiWeeklyContest_93_10_12_22;

public class MaximumValueOfStringInAnArray {

    public int maximumValue(String[] strs) {

        int max = Integer.MIN_VALUE;
        int val = 0;
        for (String s : strs) {
            if (isNumaric(s)) {
                val = Integer.parseInt(s);
            } else {
                val = s.length();
            }
            max = Math.max(max, val);
        }
        return max;
    }

    private boolean isNumaric(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                return false;
            }
        }
        return true;
    }
}
