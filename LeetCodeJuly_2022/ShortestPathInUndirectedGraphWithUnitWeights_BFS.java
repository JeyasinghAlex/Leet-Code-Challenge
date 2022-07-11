import java.util.*;

public class ShortestPathInUndirectedGraphWithUnitWeights_BFS {

    public int[] shortestPath(int n, int src, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[n];
        int[] dist = new int[n];
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        qu.offer(src);

        while (!qu.isEmpty()) {

            int curr = qu.poll();
            for (int v : adj[curr]) {
                if (dist[curr] + 1 < dist[v]) {
                    dist[v] = dist[curr] + 1;
                    qu.offer(v);
                }
            }
        }
        return dist;
    }
}
