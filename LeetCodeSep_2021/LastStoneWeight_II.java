public class LastStoneWeight_II {

    public int lastStoneWeightII(int[] stones) {

        int n = stones.length;
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }

        int[][] dp = new int[n + 1][sum / 2 + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= sum / 2; ++j) {

                if (j < stones[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(stones[i - 1] + dp[i - 1][j - stones[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return sum - (2 * dp[n][sum / 2]);
    }
}
