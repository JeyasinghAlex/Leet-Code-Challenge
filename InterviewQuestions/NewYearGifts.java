package InterviewQuestions;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Amazon
 */
public class NewYearGifts {

    public int reduceGifts(List<Integer> prices, int k, int threshold) {

        int n= prices.size();
        Collections.sort(prices);
        long[] prefSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            prefSum[i + 1] = prefSum[i] + prices.get(i);
        }
        int res = 0;
        for (int i = n; i >= k; --k) {
            if (prefSum[i] - prefSum[i - k] > threshold) {
                ++res;
            }
        }
        return res;
    }
}
