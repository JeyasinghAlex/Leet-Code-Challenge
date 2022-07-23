import java.util.*;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        List<int[]>[] adj = new ArrayList[n];
        int[] parent = new int[n];
        int[] cost = new int[n];
        boolean[] mstSet = new boolean[n];
        Queue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < n; ++j) {

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj[i].add(new int[]{j, dis});
                adj[j].add(new int[]{i, dis});
            }
        }

        for (int i = 0; i < n; ++i) {
            cost[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        cost[0] = 0;

        qu.offer(new int[]{0, cost[0]});

        while (!qu.isEmpty()) {

            int[] curr = qu.poll();
            int u = curr[0];

            if (mstSet[u]) {
                continue;
            }
            mstSet[u] = true;

            for (int[] next : adj[u]) {

                int v = next[0];
                int w = next[1];

                if (!mstSet[v] && w < cost[v]) {
                    cost[v] = w;
                    parent[v] = u;
                    qu.offer(new int[]{v, w});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += cost[i];
        }
        return ans;
    }
    public int minCostConnectPoints_1(int[][] points) {

        int n = points.length;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                graph[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }

        boolean[] visited = new boolean[n];
        int[] values = new int[n];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[0] = 0;

        for (int i = 0; i < n; ++i) {

            int u = selectMinimumVertex(visited, values);
            visited[u] = true;

            for (int j = 0; j < n; ++j) {
                if (!visited[j]) {
                    values[j] = Math.min(values[j], graph[u][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += values[i];
        }
        return ans;
    }

    private int selectMinimumVertex(boolean[] visited, int[] values) {

        int min = Integer.MAX_VALUE;
        int vertex = 0;
        for (int i = 0; i < visited.length; ++i) {
            if (!visited[i] && values[i] < min) {
                min = values[i];
                vertex = i;
            }
        }
        return vertex;
    }
}
