import java.util.List;

public class CycleDetectionInUndirectedGraphUsingDFS {

    public boolean isCycle(int v, List<List<Integer>> adj) {

        boolean[] visited = new boolean[v + 1];
        for (int i = 1; i <= v; ++i) {
            if (!visited[i]) {
                if (dfs(i ,-1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int curr, int parent, boolean[] visited, List<List<Integer>> adj) {

        visited[curr] = true;
        for (int v : adj.get(curr)) {
            if (!visited[v]) {
                if (dfs(v, curr, visited, adj)) {
                    return true;
                }
            } else if (v != parent) {
                return true;
            }
        }
        return false;
    }
}
