import java.util.*;

public class NetworkDelayTime {

    public int bellmanFord(int[][] times, int n, int k) {

        if (k > times.length) {
            return -1;
        }

        int[] path = new int[n + 1];
        Arrays.fill(path, Integer.MAX_VALUE);
        path[k] = 0;
        for (int i = 1; i <= n; ++i) {

            int[] values = path.clone();

            for (int[] edge : times) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (path[u] != Integer.MAX_VALUE && path[u] + wt < values[v]) {
                    values[v] = path[u] + wt;
                }
            }
            path = values;
        }

        int max = -1;
        for (int i = 1; i <= n; ++i) {

            if (path[i] == Integer.MAX_VALUE) {
                return -1;
            }

            if (path[i] != Integer.MAX_VALUE && path[i] > max) {
                max = path[i];
            }
        }
        return max;
    }

    public int djikstra(int[][] times, int n, int k) {

        if (k > times.length) {
            return -1;
        }
        List<int[]>[] adj = new ArrayList[n + 1];
        int[] values = new int[n + 1];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[k] = 0;
        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj[u].add(new int[]{v, wt});
        }

        qu.offer(new int[]{k, 0});

        while (!qu.isEmpty()) {
            int[] temp = qu.poll();
            int v = temp[0];
            int cost = temp[1];

            for (int[] next : adj[v]) {
                if (cost + next[1] < values[next[0]]) {
                    qu.offer(new int[]{next[0], cost + next[1]});
                    values[next[0]] = cost + next[1];
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= n; ++i) {
            if (values[i] == Integer.MAX_VALUE) {
                return -1;
            }

            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}
