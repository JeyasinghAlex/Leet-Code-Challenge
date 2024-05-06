public class CoinChange_II {


    public int change(int amount, int[] coins) {

        int n = coins.length;
        Integer[][] dp = new Integer[n + 1][amount + 1]; 
        return memo(0, amount, coins, dp);  
    }

    private int memo(int index, int amount, int[] coins, Integer[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (index == coins.length) {
            return 0;
        }
        
        if (dp[index][amount] != null) {
            return dp[index][amount];
        }

        if (coins[index] > amount) {
            int notTaken = memo(index + 1, amount, coins, dp);
            dp[index][amount] = notTaken;
        }
        else {
            int taken = memo(index, amount - coins[index], coins, dp);
            int notTaken = memo(index + 1, amount, coins, dp);
            dp[index][amount] = taken + notTaken;
        }
        return dp[index][amount];
    }
    

    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= amount; ++j) {

                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
