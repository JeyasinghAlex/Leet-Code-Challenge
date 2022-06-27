import java.util.ArrayList;
import java.util.List;

public class DFS_Graph {

    public List<Integer> dfsOfGraph(int v, List<List<Integer>> adj) {

        boolean[] visited = new boolean[v + 1];
        List<Integer> dfs = new ArrayList<>();
        for (int i = 1; i <= v; ++i) {
            if (!visited[i]) {
                dfs(i, visited, adj, dfs);
            }
        }
        return dfs;
    }


    private void dfs(int vertex, boolean[] visited, List<List<Integer>> adj, List<Integer> dfs) {

        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        dfs.add(vertex);
        for (int v : adj.get(vertex)) {
            dfs(v, visited, adj, dfs);
        }
    }
}
