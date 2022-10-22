package WeeklyContest_305_07_08_22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReachableNodesWithRestrictions {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {

        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        Set<Integer> set = new HashSet<>();
        for (int r : restricted) {
            set.add(r);
        }

        return dfs(adj, visited, set, 0);
    }

    private int dfs(List<Integer>[] adj, boolean[] visited, Set<Integer> res, int curr) {

        if (visited[curr]) {
            return 0;
        }

        visited[curr] = true;

        int cnt = 1;
        for (int v : adj[curr]) {
            if (!res.contains(v)) {
                cnt += dfs(adj, visited, res, v);
            }

        }
        return cnt;
    }
}
