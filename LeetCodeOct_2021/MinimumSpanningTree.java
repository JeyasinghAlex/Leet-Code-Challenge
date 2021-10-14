import java.util.Arrays;
import java.util.List;

public class MinimumSpanningTree {

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        int[] values = new int[V];
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(values, Integer.MAX_VALUE);
        values[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < V; ++i) {

            int u = selectMinimumVertex(values, visited);
            visited[u] = true;

            for (List<Integer> al : adj.get(u)) {
                int v = al.get(0);
                int wt = al.get(1);
                if (!visited[v] && wt < values[v]) {
                    values[v] = wt;
                    parent[v] = u;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < V; ++i) {
            ans += values[i];
        }
        return ans;
    }

    private int selectMinimumVertex(int[] values, boolean[] visited) {

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
