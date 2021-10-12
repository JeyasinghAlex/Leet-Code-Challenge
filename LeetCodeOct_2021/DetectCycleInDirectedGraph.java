import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraph {

    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[v];
        boolean[] dfsvis = new boolean[v];
        for (int i = 0; i < v; ++i) {

            if (!visited[i]) {
                boolean  flag = dfs(i, adj, visited, dfsvis);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int curr, List<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsvis) {

        if (dfsvis[curr]) {
            return true;
        }

        visited[curr] = true;
        dfsvis[curr] = true;

        for (int i = 0; i < adj.get(curr).size(); ++i) {
            int a = adj.get(curr).get(i);
            if (!visited[a]) {
                boolean flag = dfs(a, adj, visited, dfsvis);
                if (flag) {
                    return true;
                }
            } else if (dfsvis[a]) {
                return true;
            }
        }
        dfsvis[curr] = false;
        return false;
    }
}
