public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
            }
        }

        int max = 0;
        for (int i = 2; i < len; ++i) {
            for (int j = 0; j < len - i; ++j) {

                if (s.charAt(j) == s.charAt(i + j) && dp[j + 1][i - 1 + j]) {
                    dp[j][i + j] = true;
                    if (Math.abs(j - (i + j)) > max) {
                        start = j;
                        end = i + j;
                        max = Math.abs(j - (i + j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; ++i) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
