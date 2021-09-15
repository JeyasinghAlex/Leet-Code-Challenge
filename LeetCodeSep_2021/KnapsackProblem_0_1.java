import java.util.Arrays;

public class KnapsackProblem_0_1 {

    public static void main(String[] args) {
        int[] w = {2, 3, 4, 5};
        int[] p = {1, 2, 5, 6};
        System.out.println(new KnapsackProblem_0_1().knapsack(w, p, 8));
    }

    public int knapsack(int[] weight, int[] profit, int w) {

        int n = weight.length;

        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= weight.length; ++i) {
            for (int j = 1; j <= w; ++j) {
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[n][w];
    }
}
