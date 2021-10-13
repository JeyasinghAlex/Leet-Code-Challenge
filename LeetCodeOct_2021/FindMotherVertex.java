import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMotherVertex {

    public int findMotherVertex(int v, List<ArrayList<Integer>>adj) {
        // Code here
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) {
            dfs(i, visited, adj);
            boolean flag = true;
            for (int j = 0; j < v; ++j) {
                if (!visited[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
            Arrays.fill(visited, false);
        }
        return -1;
    }

    private void dfs(int curr, boolean[] visited, List<ArrayList<Integer>> adj) {

        if (visited[curr]) {
            return;
        }

        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); ++i) {
            int a = adj.get(curr).get(i);
            dfs(a, visited, adj);
        }
    }
}
