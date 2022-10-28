package WeeklyContest_304_31_07_22;

import java.util.ArrayList;
import java.util.List;

public class LongestCycleInGraph {

    public int longestCycle(int[] edges) {

        int n = edges.length;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            if (edges[i] != -1)
                adj[i].add(edges[i]);
        }


        int[] visited = new int[n];

        int[] len = new int[n];

        for (int i = 0; i < n; ++i) {
            if (visited[i] == 0) {
                isCycle(adj, visited, i, 1, len);
            }
        }
        return max;
    }

    private int max = -1;
    private void isCycle(List<Integer>[] adj, int[] visited, int curr, int dis, int[] len) {

        if (visited[curr] == 1) {
            max = Math.max(max, dis - len[curr]);
            return;
        }

        if (visited[curr] == 2) {
            return ;
        }

        visited[curr] = 1;
        len[curr] = dis;

        for (int v : adj[curr]) {
            isCycle(adj, visited, v, dis + 1, len);

        }

        visited[curr] = 2;
    }
}
