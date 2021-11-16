import java.util.ArrayList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                ++count;
            }
        }
        return count - 1;
    }

    private void dfs(int curr, List<Integer>[] adj, boolean[] visited) {

        if (visited[curr]){
            return ;
        }

        visited[curr] = true;

        for (int next : adj[curr]) {
            if (!visited[next]) {
                dfs(next, adj, visited);
            }
        }
    }
}
