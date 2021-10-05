public class PredictTheWinner {

    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        if ((n & 1) == 0) {
            return true;
        }

        int[][] dp = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i < n - l; ++i) {
                int j = i + 1 + l - 1;
                int a = (i + 1) < n && (j - 1) >= 0 ? dp[i + 1][j - 1] : 0;
                int b = (i + 2) < n ? dp[i + 2][j] : 0;
                int c = (i + 1) < n && (j - 1) >= 0 ? dp[i + 1][j - 1] : 0;
                int d = (j - 2) >= 0 ? dp[i][j - 2] : 0;
                int min1 = Math.min(a, b);
                int min2 = Math.min(c, d);
                dp[i][j] = Math.max(nums[i] + min1, nums[j] + min2);
            }
        }
        int player1 = dp[0][n - 1];
        int player2 = sum - player1;
        return player1 >= player2;
    }

    public boolean PredictTheWinner_1(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
