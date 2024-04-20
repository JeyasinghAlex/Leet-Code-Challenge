package LeetCode_2024;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {

        int n = queries.length;
        int[][] queriesWithIndex = new int[n][2];

        for (int i = 0; i < n; ++i) {
            queriesWithIndex[i][0] = queries[i];
            queriesWithIndex[i][1] = i;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queriesWithIndex, (a, b) -> a[0] - b[0]);

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> ((a[1] - a[0]) - (b[1] - b[0])));
        int[] ans = new int[n];

        int j = 0;
        for (int i = 0; i < n; ++i) {
            int qVal = queriesWithIndex[i][0];
            int qIndex = queriesWithIndex[i][1];

            while (j < intervals.length && intervals[j][0] <= qVal) {
                pq.offer(intervals[j]);
                ++j;
            }

            while (!pq.isEmpty() && pq.peek()[1] < qVal) {
                pq.poll();
            }

            ans[qIndex] = pq.isEmpty() ? -1 : (pq.peek()[1] - pq.peek()[0] + 1);
        }
        return ans;
    }
}
