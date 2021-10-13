import java.util.ArrayList;
import java.util.List;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int start, int end) {

        boolean[] visited = new boolean[n];
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return dfs(start, end, adj, visited);
    }

    private boolean dfs(int curr, int end, List<Integer>[] adj, boolean[] visited) {

        if (curr == end) {
            return true;
        }

        if (visited[curr]) {
            return false;
        }

        visited[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                boolean flag = dfs(v, end, adj, visited);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
