package WeeklyContest_318_06_11_22;

import java.util.PriorityQueue;
import java.util.Queue;

public class TotalCostToHire_K_Workers {

    public long totalCost(int[] costs, int k, int candidates) {

        long cost = 0L;

        int n = costs.length;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        for (int i = 0; i < candidates; ++i) {
            pq.offer(new int[]{costs[i], i, 0});
        }
        int left = candidates;
        int right = -1;

        for (int i = n - 1; i >= n - candidates; --i) {
            if (i < left) {
                break;
            }
            pq.offer(new int[]{costs[i], i, 1});
            right = i - 1;
        }

        for (int i = 0; i < k; ++i) {
            int[] temp = pq.poll();
            cost += temp[0];

            if (temp[2] == 0) {
                if (left <= right) {
                    pq.offer(new int[]{costs[left], left, 0});
                    ++left;
                }
            }else {
                if (left <= right) {
                    pq.offer(new int[]{costs[right], right, 1});
                    --right;
                }
            }
        }
        return cost;
    }
}
