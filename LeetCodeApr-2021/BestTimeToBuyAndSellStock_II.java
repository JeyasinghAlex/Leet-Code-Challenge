public class BestTimeToBuyAndSellStock_II {


    //    Approach 2: Peak Valley Approach
    public int maxProf(int[] prices) {
        int peek = 0, vally = 0, maxProfit = 0, i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                ++i;
            }
            vally = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                ++i;
            }
            peek = prices[i];
            maxProfit += peek - vally;
        }
        return maxProfit;
    }

    //    Approach 3: Simple One Pass
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
