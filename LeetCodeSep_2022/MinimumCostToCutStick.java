import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCostToCutStick {

    public int minCost(int n, int[] cuts) {

        int len = cuts.length;

        Arrays.sort(cuts);

        List<Integer> list = new ArrayList<>();

        list.add(0);

        for (int i = 0; i < len; ++i) {
            list.add(cuts[i]);
        }

        list.add(n);

        int[][] dp = new int[len + 2][len + 2];

        for (int i = len; i >= 1; --i) {
            for (int j = i; j <= len; ++j) {
                int min = Integer.MAX_VALUE;

                for (int idx = i; idx <= j; ++idx) {

                    int steps = list.get(j + 1) - list.get(i - 1) + dp[i][idx - 1] + dp[idx + 1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][len];
    }
}
