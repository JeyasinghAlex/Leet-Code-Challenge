package Graph;

import java.util.ArrayList;
import java.util.List;

public class CycleDetectionInUndirectedGraphUsingDFS {

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; ++i) {

            if (!visited[i]) {
                boolean flag = dfs(i, -1, adj, visited);
                if (flag) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean dfs(int curr, int parent, List<Integer>[] adj, boolean[] visited) {

        visited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                if (dfs(v, curr, adj, visited)) {
                    return true;
                }
            }
            else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}
