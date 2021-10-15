import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInTree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return dfs(0, visited, adj, hasApple);
    }


    private int dfs(int curr, boolean[] visited, List<Integer>[] adj, List<Boolean> hasApple) {

        int ans = 0;

        if (visited[curr]) {
            return 0;
        }

        visited[curr] = true;

        for (int v : adj[curr]) {
            ans += dfs(v, visited, adj, hasApple);
        }

        if ((ans > 0 || hasApple.get(curr)) && curr != 0) {
            ans += 2;
        }

        return ans;
    }
}
