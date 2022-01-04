
public class LongestValidParentheses_1 {

    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            }
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0; right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ++left;
            } else {
                ++right;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }
        return maxLen;
    }
}
