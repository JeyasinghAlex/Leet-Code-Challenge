package WeeklyContest_294_22_05_22;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumBagsWithFullCapacityOfRocks {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int n = capacity.length;
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; ++i) {
            int cap = capacity[i];
            int rock = rocks[i];

            pq.offer(cap - rock);
        }

        int ans = 0;
        while (additionalRocks > 0 && !pq.isEmpty()) {

            int need = pq.poll();

            additionalRocks -= need;
            if (additionalRocks < 0) {
                break;
            }
            ++ans;
        }
        return ans;
    }
}
