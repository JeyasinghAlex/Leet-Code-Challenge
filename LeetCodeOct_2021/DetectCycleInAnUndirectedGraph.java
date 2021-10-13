import java.util.ArrayList;
import java.util.List;

public class DetectCycleInAnUndirectedGraph {

    public boolean isCycle(int v, List<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                boolean flag = dfs(i, -1, visited, adj);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int curr, int prev, boolean[] visited, List<ArrayList<Integer>> adj) {

        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); ++i) {

            int a = adj.get(curr).get(i);

            if (!visited[a]) {
                boolean flag = dfs(a, curr, visited, adj);
                if (flag) {
                    return true;
                }
            } else if(a != prev){
                return true;
            }
        }
        return false;
    }
}
