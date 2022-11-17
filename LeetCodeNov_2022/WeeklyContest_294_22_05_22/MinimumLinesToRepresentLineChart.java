package WeeklyContest_294_22_05_22;

import java.util.Arrays;

public class MinimumLinesToRepresentLineChart {

    /**
     * Calculate the slope (A[i-1], A[i]) and (A[i],A[i+1])
     * Avoid float calculation.
     * (Fun fact: 0.1 +0.2 != 0.3 in computer science)
     *
     * From (y1 - y0) / (x1 - x0) / == (y2 - y1) / (x2 - x1) in float division,
     * we have (y1 - y0) * (x2 - x1) == (y2 - y1) * (x1 - x0) in integer multiplication.
     *
     */
    public int minimumLines(int[][] stockPrices) {

        int n = stockPrices.length;
        int ans = n - 1;

        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);

        for (int i = 1; i < n - 1; ++i) {

            int[] prev = stockPrices[i -1];
            int x0 = prev[0];
            int y0 = prev[1];
            int[] curr = stockPrices[i];
            int x1 = curr[0];
            int y1 = curr[1];
            int[] next = stockPrices[i + 1];
            int x2 = next[0];
            int y2 = next[1];

            if ((long) (x1 - x0) * (y2 - y1) == (long) (y1 - y0) * (x2 - x1)) {
                ans--;
            }
        }
        return ans;
    }
}
