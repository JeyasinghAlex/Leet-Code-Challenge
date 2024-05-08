public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        
        int l = s1.length();
        int m = s2.length();
        int n = s3.length();

        if (l + m != n) {
            return false;
        }

        Boolean[][] dp = new Boolean[l + 1][m + 1];
        return helper(0, 0, s1, s2, s3, dp);
    }

    private boolean helper(int idx1, int idx2, String s1, String s2, String s3, Boolean[][] dp) {

        if (idx1 == s1.length() && idx2 == s2.length()) {
            return true;
        }

        if (dp[idx1][idx2] != null) {
            return dp[idx1][idx2];
        }
        
        boolean isValid = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx1 + idx2)) {
            isValid |= helper(idx1 + 1, idx2, s1, s2, s3, dp);
        }
        if (!isValid && idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx1 + idx2)) {
            isValid |= helper(idx1, idx2 + 1, s1, s2, s3, dp);
        }
        dp[idx1][idx2] = isValid;
        return dp[idx1][idx2];
    }

    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length();
        int n =  s2.length();

        if (n + m != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; ++i) {
            dp[0][i] = dp[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= m; ++i) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int k = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }
        return dp[m][n];
    }
}
