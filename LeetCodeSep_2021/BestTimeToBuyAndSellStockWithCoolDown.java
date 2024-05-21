public class BestTimeToBuyAndSellStockWithCoolDown {

    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        Integer[][] dp = new Integer[n][2];
        return memo(0, 1, dp, prices);
    }

    private int memo(int index, int isBuy, Integer[][] dp, int[] prices) {

        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][isBuy] != null) {
            return dp[index][isBuy];
        }

        if (isBuy == 1) {
            int max = Math.max(-prices[index] + memo(index + 1, 0, dp, prices), 0 + memo(index + 1, 1, dp, prices));
            return dp[index][isBuy] = max;
        }
        else {
            int max = Math.max(prices[index] + memo(index + 2, 1, dp, prices), 0 + memo(index + 1, 0, dp, prices));
            return dp[index][isBuy] = max;
        }
    }
    
    public int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] noStack = new int[n];
        int[] inHand =new int[n];
        int[] sold = new int[n];

        inHand[0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            noStack[i] = Math.max(noStack[i - 1], sold[i - 1]);
            inHand[i] = Math.max(inHand[i - 1], noStack[i - 1] - prices[i]);
            sold[i] = inHand[i - 1] + prices[i];
        }
        return Math.max(noStack[n - 1], sold[n - 1]);
    }
}
