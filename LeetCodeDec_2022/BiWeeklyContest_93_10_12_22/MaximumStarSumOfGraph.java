package BiWeeklyContest_93_10_12_22;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumStarSumOfGraph {

    public int maxStarSum(int[] vals, int[][] edges, int k) {

        int n = vals.length;
        List<Integer>[] adj = new ArrayList[n];
        Queue<Integer>[] pq = new PriorityQueue[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
            pq[i] = new PriorityQueue<>((a, b) -> b - a);
        }

        for (int i = 0; i < edges.length; ++i) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];


            adj[u].add(v);
            adj[v].add(u);
        }
        for (int i = 0; i < n; ++i) {
            for (int v : adj[i]) {
                pq[i].offer(vals[v]);
            }
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            Queue<Integer> qu = pq[i];
            long sum = vals[i];
            int len = k;
            int val = vals[i];
            max = Math.max(max, val);

            while (!qu.isEmpty() && len > 0) {
                sum += qu.poll();
                len--;
                max = Math.max(max, sum);
            }
        }
        return (int) max;
    }
}
