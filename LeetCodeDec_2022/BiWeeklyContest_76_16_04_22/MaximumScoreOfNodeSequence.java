package BiWeeklyContest_76_16_04_22;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumScoreOfNodeSequence {

    public int maximumScore(int[] scores, int[][] edges) {

        int n = scores.length;
        Queue<Integer>[] adj = new PriorityQueue[n];
        int ans = -1;

        for (int i = 0 ; i < n; ++i) {
            adj[i] = new PriorityQueue<>((a, b) -> scores[a] - scores[b]);
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);


            if (adj[u].size() > 3) {
                adj[u].poll();
            }
            if (adj[v].size() > 3) {
                adj[v].poll();
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            for (int i : adj[u]) {
                for (int j : adj[v]) {

                    if (i != j && i != v && j != u) {
                        ans = Math.max(ans, scores[i] + scores[j] + scores[u] + scores[v]);
                    }
                }
            }
        }
        return ans;
    }
}
