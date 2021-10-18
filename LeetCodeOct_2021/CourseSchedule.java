import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int n, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        boolean[] dfsvis = new boolean[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                boolean flag = dfs(i, visited, dfsvis, adj);
                if (flag) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int curr, boolean[] visited, boolean[] dfsvis, List<Integer>[] adj) {

        if (visited[curr]) {
            return true;
        }

        visited[curr] = true;
        dfsvis[curr] = true;

        for (int v : adj[curr]) {
            if (!visited[v]) {
                boolean flag = dfs(v, visited, dfsvis, adj);
                if (flag) {
                    return true;
                }
            } else if (dfsvis[v]) {
                return true;
            }
        }
        dfsvis[curr] = false;
        return false;
    }
}