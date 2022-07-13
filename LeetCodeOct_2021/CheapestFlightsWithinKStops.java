import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[src] = 0;

        for (int i = 0; i <= k; ++i) {

            int[] values = path.clone();

            for (int[] edge : flights) {

                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (path[u] != Integer.MAX_VALUE && path[u] + wt < values[v]) {
                    values[v] = path[u] + wt;
                }
            }
            path = values;
        }
        return path[dst] != Integer.MAX_VALUE ? path[dst] :  -1;
    }

    public int findCheapestPrice_1(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj[u].add(new int[]{v, w});
        }

        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        qu.offer(new int[]{src, 0, k + 1});

        while (!qu.isEmpty()) {

            int[] arr = qu.poll();
            int curr = arr[0];
            int weight = arr[1];
            int stop = arr[2];

            if (dst == curr) {
                return weight;
            }

            if (stop > 0) {
                for (int[] edge : adj[curr]) {
                    int v = edge[0];
                    int w = edge[1];

                    qu.offer(new int[]{v, weight + w, stop - 1});
                }
            }
        }
        return -1;
    }
}
