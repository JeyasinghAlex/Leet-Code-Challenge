package WeeklyContest_298_19_06_22;

public class SellingPiecesOfWood {
    public long sellingWood(int m, int n, int[][] prices) {

        int[][] price = new int[m + 1][n + 1];
        Long[][] memo = new Long[m + 1][n + 1];

        for (int[] p : prices) {
            int x = p[0];
            int y = p[1];
            int amount = p[2];

            price[x][y] = amount;
        }

        long ans = memoization(m, n, price, memo);
        return ans;
    }


    private long memoization(int row, int col, int[][] prices, Long[][] memo) {

        if (row == 1 && col == 1) {
            return prices[row][col];
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }
        long ans = prices[row][col];
        for (int i = 1; i <= row / 2; ++i) {
            ans = Math.max(ans, memoization(i, col, prices, memo) + memoization(row - i, col, prices, memo));
        }

        for (int i = 1; i <= col / 2; ++i) {
            ans = Math.max(ans, memoization(row, i, prices, memo) + memoization(row, col - i, prices, memo));
        }
        memo[row][col] = ans;
        return ans;
    }

}
