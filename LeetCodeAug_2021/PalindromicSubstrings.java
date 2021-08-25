public class PalindromicSubstrings {

    public int countSubstrings(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = n;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count += 1;
                dp[i - 1][i] = true;
            }
        }

        for (int i = 2; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {

                if (s.charAt(j) == s.charAt(i + j) && dp[j + 1][i - 1 + j]) {
                    dp[j][i + j] = true;
                    count += 1;
                }
            }
        }
        return count;
    }
}
