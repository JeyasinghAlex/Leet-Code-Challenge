import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumSpanningTree_PrimsAlgorithm {

    public int[] findMST(int n, int[][] edges) {

        List<int[]>[] adj = new ArrayList[n];
        int[] cost = new int[n];
        int[] parent = new int[n];
        boolean[] mstSet = new boolean[n];
        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        for (int i = 0; i < n; ++i) {
            cost[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        cost[0] = 0;

        qu.offer(new int[]{0, cost[0]});

        for (int i = 0; i < n - 1; ++i) {

            int[] curr = qu.poll();
            int u = curr[0];
            mstSet[u] = true;

            for (int[] next : adj[u]) {
                int v = next[0];
                int w = next[1];

                if (!mstSet[v] && w < cost[v]) {
                    parent[v] = u;
                    cost[v] = w;
                    qu.offer(new int[]{v, w});
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            System.out.println(i + " vertex parent - " + parent[i]);
        }
        return parent;
    }
}
