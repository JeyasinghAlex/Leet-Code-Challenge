public class MaximumScoreAfterSplittingString {

    public int maxScore(String s) {

        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        for (char ch : s.toCharArray()) {
            right += ch - '0';
        }

        for (int i = 0; i < s.length() - 1; ++i) {
            char ch = s.charAt(i);
            int temp = ch - '0';
            if (temp == 0) {
                left += 1;
            }
            right -= temp;
            max = Math.max(max, right + left);
        }
        return max;
    }
}
