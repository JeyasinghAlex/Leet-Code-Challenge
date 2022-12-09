package WeeklyContest_290_24_04_22;

import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfFlowersInFullBloom {

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {

        /*3 events:
        0 - Bloom
        1 - Person
        2 - Die
	    */

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int n = persons.length;
        for (int i = 0; i < n; ++i) {
            pq.offer(new int[]{persons[i], 1, i});
        }

        for (int[] flower : flowers) {
            pq.offer(new int[]{flower[0], 0});
            pq.offer(new int[]{flower[1], 2});
        }

        int blooms = 0;
        int[] ans = new int[n];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] == 0) {
                ++blooms;
            } else if (curr[1] == 2) {
                --blooms;
            } else {
                int idx = curr[2];
                ans[idx] = blooms;
            }
        }
        return ans;
    }
}
