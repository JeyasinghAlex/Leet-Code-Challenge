package WeeklyContest_289_17_04_22;

import java.util.ArrayList;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {

    public int longestPath(int[] parent, String s) {

        int n = parent.length;
        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; ++i) {
            int u = i;
            int v = parent[u];

            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited, adj, s);
            }
        }
        return ans;
    }

    private int ans = Integer.MIN_VALUE;

    private int dfs(int curr, boolean[] visited, List<Integer>[] adj, String s) {


        visited[curr] = true;
        int firstMax = 0;
        int secondMax = 0;

        for (int v : adj[curr]) {
            if (!visited[v] && s.charAt(curr) != s.charAt(v)) {
                int max = dfs(v, visited, adj, s);
                if (max > firstMax) {
                    secondMax = firstMax;
                    firstMax = max;
                }
                else if (max > secondMax) {
                    secondMax = max;
                }
            }
        }

        ans = Math.max(ans, 1 + firstMax + secondMax);
        return 1 + firstMax;
    }
}
