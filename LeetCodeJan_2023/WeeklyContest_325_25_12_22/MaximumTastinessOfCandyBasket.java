package WeeklyContest_325_25_12_22;

import java.util.Arrays;

public class MaximumTastinessOfCandyBasket {

    public int maximumTastiness(int[] price, int k) {

        int n = price.length;
        int left = 0;
        int right = (int) 1e9;
        Arrays.sort(price);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int count = 1;
            for (int i = 1, prev = 0; i < n; i++) {
                if (price[i] - price[prev] >= mid) {
                    count++;
                    prev = i;
                }
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
