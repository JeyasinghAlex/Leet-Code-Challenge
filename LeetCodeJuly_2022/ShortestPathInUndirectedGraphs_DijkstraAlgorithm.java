import java.util.*;

public class ShortestPathInUndirectedGraphs_DijkstraAlgorithm {


    public int[] shortestPath(int n, int src, int[][] prerequisites) {

        int r = prerequisites.length;
        int c = prerequisites[0].length;

        List<int[]>[] adj = new ArrayList[n];
        int[] dist = new int[n];
        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (prerequisites[i][j] != 0) {
                    int weight = prerequisites[i][j];
                    adj[i].add(new int[]{j, weight});
                    adj[j].add(new int[]{i, weight});
                }
            }
        }

        dist[src] = 0;
        qu.offer(new int[]{src, 0});

        while (!qu.isEmpty()) {

            int[] temp = qu.poll();
            int curr = temp[0];
            int weight = temp[1];

            for (int[] arr : adj[curr]) {

                int v = arr[0];
                int w = arr[1];

                if (dist[curr] + w < dist[v]) {
                    dist[v] = dist[curr] + w;
                    qu.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
