package BiWeeklyContest_86_3_9_22;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumNumberOfRobotsWithinBudget {

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

        int n = chargeTimes.length;
        Queue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());

        long cost = 0;
        int res = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < n; ++i) {

            cost += runningCosts[i];
            qu.offer(chargeTimes[i]);

            while (!qu.isEmpty() && (qu.peek() + qu.size() * cost > budget)) {
                cost -= runningCosts[j];
                qu.remove(chargeTimes[j]);
                ++j;
            }
            res = Math.max(res, qu.size());
        }
        return res;
    }
}
