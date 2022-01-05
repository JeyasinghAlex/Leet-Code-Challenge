public class WildcardMatching {

    public boolean isMatch(String s, String p) {

        StringBuilder pattern = new StringBuilder();

        for (int i = 0; i < p.length(); ++i) {
            char ch = p.charAt(i);
            pattern.append(ch);
            boolean visite = false;
            while (i < p.length() && p.charAt(i) == '*') {
                visite = true;
                ++i;
            }
            if (visite) {
                --i;
            }
        }

        p = pattern.toString();
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        if (p.length() > 0 && p.charAt(0) == '*') {
            dp[0][1] = true;
        }

        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
