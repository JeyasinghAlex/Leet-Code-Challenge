public class CoinChange {


    public int findLowestCoins(int[]coins, int cur, int amount) {
        if (cur >= coins.length || amount <= 0)
            return (amount == 0) ? 0 : INT_MAX - 1;   
        
        int res = -1;
        if (coins[cur] > amount) {
            int doNotTakeCoin = 0 + findLowestCoins(coins, cur + 1, amount - 0);
            res = doNotTakeCoin;
        }
        else {
            int takeCoin = 1 + findLowestCoins(coins, cur + 0, amount - coins[cur]);
            int doNotTakeCoin = 0 + findLowestCoins(coins, cur + 1, amount - 0);
            res = min(takeCoin, doNotTakeCoin);
        }
        return res;
    }

    int dp[12 + 1][10000 + 1];
    public int findLowestCoins(int[] coins, int cur, int amount) {
        if (cur == coins.length || amount <= 0)
            return (amount == 0) ? 0 : INT_MAX - 1;   
        
        if (dp[cur][amount] != -1)
            return dp[cur][amount];
        
        int res = -1;
        if (coins[cur] > amount) {
            int doNotTakeCoin = 0 + findLowestCoins(coins, cur + 1, amount - 0);
            dp[cur][amount] = res = doNotTakeCoin;
        }
        else {
            int takeCoin = 1 + findLowestCoins(coins, cur + 0, amount - coins[cur]);
            int doNotTakeCoin = 0 + findLowestCoins(coins, cur + 1, amount - 0);
            dp[cur][amount] = res = min(takeCoin, doNotTakeCoin);
        }
        return dp[cur][amount] = res;
    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= amount; ++j) {

                if (j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = (int) 1e5;
                } else if (coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        return dp[n][amount] > 1e4 ? -1 : dp[n][amount];
    }
}
