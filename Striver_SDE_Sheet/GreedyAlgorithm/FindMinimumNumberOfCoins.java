package GreedyAlgorithm;

public class FindMinimumNumberOfCoins {

    public int findMinimumCoins(int amount) {


        int[] coins = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int n = coins.length;
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (amount == 0)
                break;

            ans += amount / coins[i];
            amount = amount % coins[i];
        }
        return ans;
    }
}
