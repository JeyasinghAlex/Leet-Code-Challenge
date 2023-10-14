package Arrays;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {

            if (prices[i] < minValue)
                minValue = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - minValue);
        }
        return maxProfit;
    }
}
