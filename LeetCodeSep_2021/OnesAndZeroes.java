public class OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {

        int l = strs.length;
        int[][][] dp = new int[l + 1][m + 1][n + 1];

        for (int i = 1; i <= l; ++i) {
            int[] nums = getZeroOne(strs[i - 1]);
            for (int j = 0; j <= m; ++j) {
                for (int k = 0; k <= n; ++k) {

                    if (j < nums[0] || k < nums[1]){
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - nums[0]][k - nums[1]] + 1);
                    }
                }
            }
        }
        return dp[l][m][n];
    }

    public int findMaxForm_1(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {

            int[] nums = getZeroOne(s);
            for (int i = m; i >= nums[0]; --i) {
                for (int j = n; j >= nums[1]; --j) {
                    if (i < nums[0] || j < nums[1]) {
                        dp[i][j] = dp[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i - nums[0]][j - nums[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] getZeroOne(String s) {

        int zero = 0;
        int one = 0;
        for (char ch : s.toCharArray()) {

            if (ch == '0') {
                ++zero;
            } else {
                ++one;
            }
        }
        return new int[]{zero, one};
    }
}
