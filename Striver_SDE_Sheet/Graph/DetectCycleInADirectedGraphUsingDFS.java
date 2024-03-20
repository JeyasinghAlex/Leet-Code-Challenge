package Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInADirectedGraphUsingDFS {

    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        // Write your code here.

        List<Integer>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj[u].add(v);
        }

        boolean[] visited = new boolean[n + 1];
        boolean[] dfsvisited = new boolean[n + 1];

        for (int i = 1; i <= n; ++i) {

            if (!visited[i]) {
                boolean flag = dfs(i, adj, visited, dfsvisited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int curr, List<Integer>[] adj, boolean[] visited, boolean[] dfsvisited) {

        visited[curr] = true;
        dfsvisited[curr] = true;

        for (int v : adj[curr]) {

            if (!visited[v]) {
                boolean flag = dfs(v, adj, visited, dfsvisited);
                if (flag) {
                    return true;
                }
            } else if (dfsvisited[v]) {
                return true;
            }
        }
        dfsvisited[curr] = false;
        return false;
    }
}
