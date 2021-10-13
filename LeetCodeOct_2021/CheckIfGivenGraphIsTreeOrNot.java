import java.util.Arrays;
import java.util.List;

public class CheckIfGivenGraphIsTreeOrNot {

    public boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                boolean flag = dfs(i, -1, visited, adj);
                if (flag) {
                    return false;
                }
            }
        }

        Arrays.fill(visited, false);
        isTree(0, visited, adj);
        for (int i = 0; i < v; ++i) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isTree(int curr, boolean[] visited, List<List<Integer>> adj) {

        if (visited[curr]) {
            return true;
        }

        visited[curr] = true;

        for (int i = 0; i < adj.get(curr).size(); ++i) {
            int a = adj.get(curr).get(i);
            if (!visited[a]) {
                boolean flag = isTree(a, visited, adj);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int curr, int prev, boolean[] visited, List<List<Integer>> adj) {

        visited[curr] = true;
        for (int i = 0; i < adj.get(curr).size(); ++i) {
            int a = adj.get(curr).get(i);
            if (!visited[a]) {
                boolean flag = dfs(a, curr, visited, adj);
                if (flag) {
                    return true;
                }
            } else if (a != prev) {
                return true;
            }
        }
        return false;
    }
}
