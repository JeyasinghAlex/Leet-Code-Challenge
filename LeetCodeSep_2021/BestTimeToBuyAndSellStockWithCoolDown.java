public class BestTimeToBuyAndSellStockWithCoolDown {

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
