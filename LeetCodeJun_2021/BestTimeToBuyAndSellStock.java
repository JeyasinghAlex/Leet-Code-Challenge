public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {

            int temp = prices[i] - prices[i - 1];
            if (temp > profit) {
                profit = temp;
            }
            prices[i] = Math.min(prices[i], prices[i - 1]);
        }
        return profit;
    }
}
